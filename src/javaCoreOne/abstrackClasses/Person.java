package javaCoreOne.abstrackClasses;

public abstract class Person {
	public abstract String getDescription();
	private String name;
	public Person(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
