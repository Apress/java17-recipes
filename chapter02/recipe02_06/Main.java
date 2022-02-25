package org.java17recipes.chapter02.recipe02_06;

public class Main {
	public static void main (String[] args) {
		Professor prof = new Professor ();
		prof.setId(1);
		prof.setName("Luciano");
		prof.setSurname("Manelli");
		System.out.println("Prof "+prof.getId()+":"+prof.getName()+" "+prof.getSurname());
		
		
		record ProfessorRecord (Integer id, String name, String surname) {};
		ProfessorRecord profRecord = new ProfessorRecord (1, "Luciano", "Manelli");
		System.out.println("Prof using Record "+profRecord.id()+":"+profRecord.name()+" "+profRecord.surname());
	}
}
