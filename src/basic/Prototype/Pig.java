package Prototype;

import java.util.Date;

public class Pig implements Cloneable {
	private String name;
	private Date birthday;

	@Override
	public String toString() {
		return "Pig [name=" + name + ", birthday=" + birthday + "]" + super.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Pig(String name, Date birthday) {
		this.birthday = birthday;
		this.name = name;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// return super.clone();
		// 深克隆
		Pig pig = (Pig) super.clone();
		pig.birthday = (Date) pig.birthday.clone();
		return pig;
	}

}
