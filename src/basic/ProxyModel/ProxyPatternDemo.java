package basic.ProxyModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 代理模式的主程序入口---一个类代表另外一个类的功能
 * @exmple：windows的快捷方式，火车票代售点
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		// 图像将从磁盘加载
		image.display();
		System.out.println("");
		// 图像不需要从磁盘加载
		image.display();
	}
	
	
	
	
	/*
	 * 1、和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。
	 *  2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制。
	 */

}
