package com.wuzp.polymorphism;

public class PolyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Animal[] animal = new Animal[5];
		animal[0] = new Dog();
		animal[1] = new Cat();
		animal[2] = new Wolf();
		animal[3] = new Hippo();
		animal[4] = new Lion();
		
		for (int i = 0; i < animal.length; i++) {
//			animal[i].eat();
//			animal[i].roam();
		}
		
		Vet vet = new Vet();
		Dog dog = new Dog();
		Cat cat = new Cat();
		vet.medicalCare(dog);
		vet.medicalCare(cat);
		System.out.println(dog.age);
		
		Animal animal2 = new Animal();
		animal2.eat();
	}
	
	

}
