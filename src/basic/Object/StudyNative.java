package basic.Object;

/*
 * @author xjc
 * @date 2021-12-04
 * @desc 学习native的关键字
 */
public class StudyNative {
	// eg:public native int hashCode();
	// java平台有个用户和本地c代码进行互相操作的API，称为java native interface(java本地接口)

	/*
	 * 使用native关键字，说明这个方法是原生函数，这个方法是使用C/C++实现的，并且被编译成了dll,由java去调用的，
	 * 这些函数的实现是在dll体中，jdk的源码并不包含，
	 */
}
