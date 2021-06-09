package learn;

/*
 * @author xjc
 * @date 2021-05-31
 * @desc Integer的学习
 */
public class StudyInteger {
	public static void main(String[] args) {
		Integer a = new Integer(5);
		Integer b = new Integer(5);

		Integer c = 5;
		Integer d = 5;

		Integer e = 128; // Integer的取值范围是-128到127，无法取到相应的缓存值，需要创建对象，
		Integer f = 128;

		int g = 128;

		System.out.println(a == b);// true 真实答案是false
		System.out.println(b == c);// false
		System.out.println(c == d);// true
		System.out.println(e == f);// false
		System.out.println(f == g);// false 真实答案是true 自动装箱，自动将封装类变成int

	}
}
