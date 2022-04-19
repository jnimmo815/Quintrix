package com.quintrix.jfs.ApiDemo.models;

import java.util.Objects;

public class Cat {

	private Integer id;
	private String name;
	private Integer age;
	private String color;
	
	public Cat() {}
	
	public Cat(Integer id, String name, Integer age, String color) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// toString
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(age, color, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(age, other.age) && Objects.equals(color, other.color) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
			
	
}
