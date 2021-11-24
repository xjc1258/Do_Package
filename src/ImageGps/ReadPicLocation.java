package ImageGps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class ReadPicLocation {
	public static HashMap<String, Object> readPicInfo(String file_path) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Tag tag = null;
		File jpegFile = new File(file_path);
		Metadata metadata; 
		try {
			metadata = JpegMetadataReader.readMetadata(jpegFile);
			Iterator<Directory> it = metadata.getDirectories().iterator();
			while (it.hasNext()) {
				Directory exif = it.next();
				Iterator<Tag> tags = exif.getTags().iterator();
				while (tags.hasNext()) {
					tag = (Tag) tags.next();
					System.out.println(tag.getTagName() + "--" + tag.getDescription());   
				}
			}
		} catch (JpegProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		// 传入照片的绝对路径
		String file_path = "D:\\xjc.jpg";
		readPicInfo("D:\\xjc.jpg");
	}
}
