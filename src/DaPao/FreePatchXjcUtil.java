package DaPao;
	/**
	 * @Description:
	 * @Package:PACKAGE_NAME
	 * @author：xjc
	 * @CREAT_TIME:
	 * @Emial:liyang@china.kjlink.com
	 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FreePatchXjcUtil {
	    //补丁文件,由eclipse svn plugin生成或手动创建,格式为：Index:+空格+相对路径（src/...）
	    //eg:
	    //Index: src\main\java\com\test\framework\supplier\controller\SupplierProprietaryController.java
	    //Index: src\main\webapp\js\pages\product\configuration.js
	    //本地项目路径(src之前路径)
	    public static String projectPath="D:/DHCSoftware/Mat8.4/V9.0/CHD-HRP";
	    // web应用文件夹名（）
	    public static String webContent="WebRoot";
	    //本地项目编译class存放路径，即文件复制源
	    public static String classPath="D:/DHCSoftware/Mat8.4/V9.0/CHD-HRP/WebRoot/WEB-INF/classes";
	    //补丁文件包存放路径（打包文件地址，不存在则自动创建）
	    public static String desPath="D:/v9.0-Package/svnAdd/CHD-HRP";
	    
	    /**
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String[] args) throws Exception {
	      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	  	  Date begin = format.parse("2020-06-05");  
	  	  Date end = format.parse("2020-06-06"); 
	      copyFiles(getPatchFileList(begin,end));
	    }

	    public static List<String> getPatchFileList(Date begin,Date end) throws Exception{
	        List<String> fileList=new ArrayList<String>();
	        //拿到路径并读取
	        ModerOption test = new ModerOption();
	        String patchFile = test.PathpatchFile(test.filterCommitHistory(begin,end));
	 
	        FileInputStream f = new FileInputStream(patchFile);
	        BufferedReader dr=new BufferedReader(new InputStreamReader(f,"utf-8"));
	        String line;
	        while((line=dr.readLine())!=null){
	            if(line.indexOf("Index:")!=-1){
	                //去除路径行空格
	                line=line.replaceAll(" ","");
	                line=line.trim();
	                if(line.contains(".java")){
	                    line=line.replace("main/java/","");
	                }
	                //取相对路径从src开始
	                line=line.substring(line.indexOf(":")+1,line.length());
	                fileList.add(line);
	            }
	        }
	        dr.close();
	        return fileList;
	    }


	    public static void copyFiles(List<String> list){
	        for(String fullFileName:list){
	            if(fullFileName.contains(".java")){
	                //对源文件目录下的文件处理
	                String fileName=fullFileName.replace("src","");
	                fullFileName=classPath+fileName;
	                if(fileName.contains(".java")){
	                    fileName=fileName.replace(".java",".class");
	                    fullFileName=fullFileName.replace(".java",".class");
	                }
	                String tempDesPath=fileName.substring(0,fileName.lastIndexOf("/"));
	                String desFilePathStr=desPath+"/WEB-INF/classes"+tempDesPath;
	                String desFileNameStr=desPath+"/WEB-INF/classes"+fileName;
	                File desFilePath=new File(desFilePathStr);
	                if(!desFilePath.exists()){
	                    desFilePath.mkdirs();
	                }
	                copyFile(fullFileName, desFileNameStr);
	                System.out.println(fullFileName+"复制完成");
	                //遍历目录，是否存在内部类，如果有内部，则将所有的额内部类挑选出来放到
	                copyInnerClassFile(fullFileName, desFileNameStr);
	            }else{
	                //对普通目录的处理
	                String desFileName=fullFileName.replace(webContent,"");
	                fullFileName=projectPath+"\\"+fullFileName;
	                //将要复制的文件全路径
	                String fullDesFileNameStr=desPath+"\\"+desFileName;
	                String desFilePathStr=fullDesFileNameStr.substring(0,fullDesFileNameStr.lastIndexOf("/"));
	                File desFilePath=new File(desFilePathStr);
	                if(!desFilePath.exists()){
	                    desFilePath.mkdirs();
	                }
	                copyFile(fullFileName, fullDesFileNameStr);
	                System.out.println(fullFileName+"复制完成");
	            }
	        }
	    }
	    private static void copyFile(String sourceFileNameStr, String desFileNameStr) {
	        File srcFile = new File(sourceFileNameStr);
	        File desFile = new File(desFileNameStr);
	        try {
	            copyFile(srcFile, desFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    /***
	     * 处理内部类的情况
	     * 解析源路径名称，遍历此文件路径下是否存在这个类的内部类
	     * 内部类编译后的格式一般是 OuterClassName$InnerClassName.class
	     * @param sourceFullFileName 原路径
	     * @param desFullFileName 目标路径
	     */
	    private static void copyInnerClassFile(String sourceFullFileName,String desFullFileName){
	        String sourceFileName = sourceFullFileName.substring(sourceFullFileName.lastIndexOf("/")+1);
	        String sourcePackPath = sourceFullFileName.substring(0,sourceFullFileName.lastIndexOf("/"));
	        String destPackPath = desFullFileName.substring(0,desFullFileName.lastIndexOf("/"));
	        String tempFileName = sourceFileName.split("\\.")[0];
	        File packFile = new File(sourcePackPath);
	        if(packFile.isDirectory()){
	            String[] listFiles = packFile.list();
	            for(String fileName:listFiles){
	                //可以采用正则表达式处理
	                if(fileName.indexOf(tempFileName+"$")>-1 && fileName.endsWith(".class")){
	                    String newSourceFullFileName = sourcePackPath+"/" +fileName;
	                    String newDesFullFileName = destPackPath + "/" + fileName;
	                    copyFile(newSourceFullFileName, newDesFullFileName);
	                    System.out.println(newSourceFullFileName+"复制完成");
	                }
	            }
	        }
	    }


	    public static void copyFile(File sourceFile, File targetFile) throws IOException {
	        BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
}
