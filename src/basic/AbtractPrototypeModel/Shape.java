package basic.AbtractPrototypeModel;

/*
 * @author xjc
 * @date 2021-06-22
 * @desc 原型模式的学习  shape--形状的意思
 */
public abstract class Shape implements Cloneable {
	// 主类实现了cloneable就具备拷贝类的能力
	private String id;
	protected String type;

	// 抽象类的方法时抽象的
	abstract void draw();

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

}
