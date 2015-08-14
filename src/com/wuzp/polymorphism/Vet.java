package com.wuzp.polymorphism;

/**
 * 
 * @author wuzp
 *
 */
public class Vet {

	
	// param & return poly
		public void medicalCare(Animal animal) {
			System.out.println("the Vet's medical ---- test animal's poly--------------");
			animal.outch();
			animal.age = animal.age - 1;
			System.out.println("the age---" + animal.age);
		}
}
