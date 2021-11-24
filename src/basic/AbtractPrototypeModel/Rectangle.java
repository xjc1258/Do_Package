package basic.AbtractPrototypeModel;

/*
 * @author xjc 
 * @date 2021-06-22
 * @desc 矩形
 */
public class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("矩形的方法draw被调用");
	}

	// 无参构造，构造是属于类的
	public Rectangle() {
		type = "Rectangle";
	}

}
