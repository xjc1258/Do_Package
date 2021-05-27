package BuildingModel;
/*@author xjc
 *@date 2021-05-18
 *@desc 建造者模式
 */

public class Course {
	private String courseName;
	private String coursePPT;
	private String courseVideo;
	private String courseArticle;
	private String courseOA;

	public Course(CourseBuilder courseBuilder) {
		this.courseName = courseBuilder.courseName;
		this.coursePPT = courseBuilder.coursePPT;
		this.courseVideo = courseBuilder.courseVideo;
		this.courseArticle = courseBuilder.courseArticle;
		this.courseOA = courseBuilder.courseOA;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", coursePPT=" + coursePPT + ", courseVideo=" + courseVideo
				+ ", courseArticle=" + courseArticle + ", courseOA=" + courseOA + "]";
	}

	// 静态内部类
	public static class CourseBuilder {
		private String courseName;
		private String coursePPT;
		private String courseVideo;
		private String courseArticle;
		private String courseOA;

		public CourseBuilder buildCourseName(String courseName) {
			this.courseName = courseName;
			return this;
		}

		public CourseBuilder buildCoursePPT(String coursePPT) {
			this.coursePPT = coursePPT;
			return this;
		}

		public CourseBuilder buildCourseVideo(String courseVideo) {
			this.courseVideo = courseVideo;
			return this;
		}

		public CourseBuilder buildCourseArticle(String courseArticle) {
			this.courseArticle = courseArticle;
			return this;
		}

		public CourseBuilder buildCourseOA(String courseOA) {
			this.courseOA = courseOA;
			return this;
		}

		public Course build() {
			return new Course(this);
		}
	}

}
