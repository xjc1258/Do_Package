package basic.AbtractPrototypeModel;

/*
 * @author xjc 
 * @date 2021-06-22
 * @desc 圆形
 */
public class Circle extends Shape {
	//构造初始化，最早运行
	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("圆形的draw方法被调用");
	}

}
