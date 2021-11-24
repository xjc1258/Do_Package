package basic.Prototype;

import java.util.Date;

public class PigTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date birthday = new Date(0L);
		Pig pig1 = new Pig("佩奇", birthday);
		Pig pig2 = (Pig)pig1.clone();
		System.out.println(pig1);
		System.out.println(pig2);
		//十六进制是和hashcode是有关的，我们并没有重写hashcode
		pig1.getBirthday().setTime(66666L);
		//重新设置了pig1的生日，pig2的也跟着变了------------------------->浅克隆
		System.out.println(pig1);
		System.out.println(pig2);
		//--------------------》一般是要深克隆的
		
	}

}
