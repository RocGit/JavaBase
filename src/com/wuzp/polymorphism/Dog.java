package com.wuzp.polymorphism;

public class Dog extends Animal {
    int age = 13;
	// 狗吃
	public void eat() {
		System.out.println("the Dog's eat");
	}
	
	// 狗叫
	public void outch() {
		System.out.println("the Dog's wangwang");
	}
	
}
