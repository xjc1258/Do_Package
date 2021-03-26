package String;

public class UUIDA {
	private Person p = null;

	public static void main(String[] args) {
		// String string = UUID.randomUUID().toString();
		// System.out.println(string);
		Person p1 = new Person();
		p1.setBanji("1");
		p1.setChushengdi("2");
		p1.setCun("3");
		p1.setName("4");
		p1.setXuexiao("5");
		Person p2 = new Person();
		p2.setBanji("6");
		p2.setChushengdi("7");
		p2.setCun("8");
		p2.setName("9");
		p2.setXuexiao("10");
		Person[] b = new Person[] { p1, p2 };
		for (Person a : b) {
			a.getXuexiao();
			System.out.println(a.getXuexiao());
		}
	}

	public Person getxjc() {
		return getBasePerson();
	}

	private Person getBasePerson() {
		if (this.p == null) {
			this.p = new Person();
		}
		return this.p;
	}
}
