package be.abis.courseadmin.test;

import java.io.IOException;
import java.time.LocalDate;

import be.abis.courseadmin.exception.AgeCannotBeNegativeException;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class ExG4 {
	
	public static void main (String[] args) {
		
	  try {
	    Instructor i1 = new Instructor("Sandy","Schillebeeckx",LocalDate.of(1978,4,10),23,2000.0);		
		i1.printSalaryHistory("sandy.txt");
		
		Instructor i2 = new Instructor("Gie","Indesteege",LocalDate.of(1957,8,25),25,1900.0);		
		i2.printSalaryHistory();
		
		Course c1 = new Course("Java",3,450.0);
		c1.setPriorKnowledgeRequired(true);
		c1.addInstructor(i1);
		c1.addInstructor(i2);
		
		double totalPrice = c1.calculatePrice();
				
		c1.printInfo();
		
	  } catch (IOException| AgeCannotBeNegativeException  e){
		  System.out.println(e.getMessage());
	  } 
	}
	 
	
	
}