package basic.BuildingModel;

public class Test {
	public static void main(String[] args) {
		// 链式调用
		Course course = new Course.CourseBuilder().buildCourseArticle("222").buildCourseName("rrr").buildCourseOA("ttt")
				.buildCoursePPT("ddd").buildCourseVideo("oo").build();
		System.out.println(course);
	}
}
