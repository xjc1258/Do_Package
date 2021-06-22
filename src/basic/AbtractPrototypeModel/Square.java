package basic.AbtractPrototypeModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 正方形
 */
public class Square extends Shape {
	//构造初始化，最早运行
	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("正方形的方法draw被调用");
	}

}
