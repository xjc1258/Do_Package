package basic.AbtractPrototypeModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 抽象类实现Cloneable
 */
public abstract class A implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
