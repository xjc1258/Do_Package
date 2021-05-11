package SimpleFactory;

public class VideoFactory {

	/*
	 * 首次书写
	 */
	public Video getVideo(String type) {
		if (type.equalsIgnoreCase("java")) {
			return new JavaVideo();
		} else if (type.equalsIgnoreCase("php")) {
			return new PhpVideo();
		}
		return null;
	}

	/*
	 * 优化后(20210408浏览过)
	 */
	public Video getVideo2(Class c) {
		Video video = null;
		try {
			video = (Video) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return video;
	}

}
