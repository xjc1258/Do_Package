package basic.DaPao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.tmatesoft.svn.core.ISVNLogEntryHandler;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
 
public class ModerOption {
 
    //svn地址
    private static String url = "https://192.144.163.6:8800/svn/HRP/trunk/V8.4/src/CHD-HRP";  
    private static SVNRepository repository = null;  
 
  
    public Collection filterCommitHistory(Date begin, Date end) throws Exception {
        DAVRepositoryFactory.setup();   
        try {  
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));  
        }  
        catch (SVNException e) {  
           e.printStackTrace(); 
        }  
        // 身份验证  
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("xuejingchao","xjc0527");  
        repository.setAuthenticationManager(authManager);  
        
        long startRevision = 0;  
        long endRevision = -1;//表示最后一个版本  
        final Collection<SVNLogEntry > history = new ArrayList<>();    
        repository.log(new String[]{""},  
                       startRevision,  
                       endRevision,  
                       true,  
                       true,  
                       new ISVNLogEntryHandler() {  
                           @Override  
                           public void handleLogEntry(SVNLogEntry svnlogentry)  
                                   throws SVNException {  
                                  //依据提交时间进行过滤  
                               if (svnlogentry.getDate().after(begin)  
                                   && svnlogentry.getDate().before(end)) {  
                                    fillResult(svnlogentry);
                               }  
                           }  
  
                           public void fillResult(SVNLogEntry svnlogentry) {   
                               history.add(svnlogentry);  
                           }  
                      });  
         return history;
          
    }  
    
    public String PathpatchFile(Collection logEntries) {
    	        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    			String todaydate = format.format(new Date());  
    		    String path = "D:/v9.0-Package/svnAdd/"+todaydate+".txt";
    		
		    	FileWriter fileWriter;
				
				try {
					fileWriter = new FileWriter(path);
					for (Object temp : logEntries) {
			    		SVNLogEntry logEntry = (SVNLogEntry)temp;
			    		Map<String, SVNLogEntryPath> map= logEntry.getChangedPaths();
			    		for (Map.Entry<String, SVNLogEntryPath> entry : map.entrySet()) {
			    			String result = "Index: "+ entry.getValue().toString().substring(26,entry.getValue().toString().length());
			    			fileWriter.write(result+"\n");//换行转意	
			    		}
			    	 }
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	return path;
		    

    }
    //测试方法
    /*
    public static void main(String[] args) throws Exception {
        ModerOption test = new ModerOption();
        // 过滤条件  
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        final Date begin = format.parse("2020-06-04");  
        final Date end = format.parse("2020-06-05");  
        
       
        String todaydate = format.format(new Date());  
        String path = "D:/v9.0-Package/svnAdd/"+todaydate+".txt";
        Collection logEntries = test.filterCommitHistory(begin, end);
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(path);
			
    	for (Object temp : logEntries) {
    		SVNLogEntry logEntry = (SVNLogEntry)temp;
    		Map<String, SVNLogEntryPath> map= logEntry.getChangedPaths();
    		for (Map.Entry<String, SVNLogEntryPath> entry : map.entrySet()) {
    			String result = "Index: "+ entry.getValue().toString().substring(26,entry.getValue().toString().length());
    			fileWriter.write(result+"\n");//换行转意	
    		}
    	 }
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }*/
}