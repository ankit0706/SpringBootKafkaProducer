package com.sample.demo;

public class User {
	private final String name;
	private final int age;
	
	public User(String n, int a) {
		this.name = n;
		this.age = a;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
