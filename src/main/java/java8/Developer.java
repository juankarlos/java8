package java8;

import java.math.BigDecimal;

public class Developer {

	private String name;
	private BigDecimal salary;
	private int age;

	public Developer(String name, BigDecimal salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return String.format("%s\t%s\t%s", this.name, this.salary, this.age);
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

}