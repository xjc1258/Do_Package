package basic.AbtractPrototypeModel;

/* 
 * @author xjc
 * @date 2021-06-22
 * @desc 程序入口
 */
public class PrototypePatternDemo {

	public static void main(String[] args) {
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
	}

	/*
	 * 总结：
	 * 这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。
	 * 例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，
	 * 在需要的时候更新数据库，以此来减少数据库调用
	 * 
	 * 与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。
	 * 浅拷贝实现 Cloneable，重写，深拷贝是通过实现 Serializable 读取二进制流。
	 * 
	 */

}
