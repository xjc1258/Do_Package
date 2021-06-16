package basic.JVM;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadHa extends ClassLoader {
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String path = "e:\\myclasspath\\" + name + ".class";
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Files.copy(Paths.get(path), os);
			// 得到字节数组
			byte[] bytes = os.toByteArray();
			return defineClass(name, bytes, 0, bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
	}
}
