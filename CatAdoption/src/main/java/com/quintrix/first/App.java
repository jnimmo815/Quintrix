package com.quintrix.first;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.quintrix.bean.Cat;

public class App {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);	
			App.getNames(scan);			
			scan.close();
		
	}
	
	public static void printCats() {
		Cat cat1 = new Cat(1,"Callie", 12, "Calico");
		Cat cat2 = new Cat(2,"Feynman", 4, "Black");
		Cat cat3 = new Cat(3,"Maxwell", 5, "Brown Spots");
		Cat cat4 = new Cat(4,"Newton", 17, "Grey");
		Cat cat5 = new Cat(5,"Morris", 5, "Orange");
		
		Set<Cat> cats = new HashSet<Cat>();
		
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		cats.add(cat4);
		cats.add(cat5);		
		
		for(Cat cat : cats) {
			System.out.println(cat);
		}
	}
	
	public static void getNames(Scanner scan) {
		System.out.println("Enter your name: ");
		String yourName = scan.nextLine();
		
		System.out.println("Hello " + yourName);
		System.out.println("Welcome to the Cat Adoption App: ");
		System.out.println("Here are the availiable cats for adoption.");
		App.printCats();	
		System.out.println("Which Cat would you like to adopt?");
		String yourCat = scan.nextLine();
		
		System.out.println("You have chosen " + yourCat + " and it has been log in a text file: " + yourName);	
		App.writeToFile(yourName, yourCat);
	}
	
	public static void writeToFile(String yourName, String yourCat) {
		try(FileWriter writer = new FileWriter(yourName + ".txt") ){
		    writer.write(yourName +   " wants to adopt " +  yourCat);
		    writer.close();
		} catch (IOException e) {}		
	}
	
		
}
