package basic.String;

public class AQ {
	private String name;
    private String value;
    private String color;
	public AQ(String name, String value, String color) {
		this.name=name;
		this.value=value;
		this.color=color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		return "AQ [name=" + name + ", value=" + value + ", color=" + color + "]";
	}
	public void setColor(String color) {
		this.color = color;
	}
}
