package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import be.abis.courseadmin.exception.AgeCannotBeNegativeException;

public class Instructor {
	
	private String firstName;
	private String lastName;
	private int age;
	private int startAge;
	private double startSalary;
	
	public Instructor(String firstName,String lastName,int age,int startAge,double startSalary) throws AgeCannotBeNegativeException{
		this.firstName=firstName;
		this.lastName=lastName;
		this.setAge(age);
		this.startAge=startAge;
		this.startSalary=startSalary;
	}
	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setAge(int age) throws AgeCannotBeNegativeException{
		  if (age>=0){
			this.age=age;
		  } else {
			  throw new AgeCannotBeNegativeException("age cannot be negative");
		  }
		}
	
	public int getAge(){
		return age;
	}
	
	
	public int getStartAge(){
		return startAge;
	}
	
	public void setStartAge(int startAge){
		this.startAge=startAge;
	}
	
	public void setStartSalary(double startSalary){
		this.startSalary=startSalary;
	}
	
	public double getStartSalary(){
		return startSalary;
	}
	
	public void printSalaryHistory() throws IOException{
		 this.printSalaryHistory("salaryhistory.txt");
       System.out.println("salaryhistory.txt was created");
	}
	
	public void printSalaryHistory(String fileName) throws IOException{
		 
		 BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName));
		 int seniority =0;		 
		 double salary=startSalary;
		  for (int loopAge=startAge; loopAge<=age ; loopAge+=5) {
			if (loopAge!=startAge) salary=salary*1.03;
			bw.write("Salary of " + firstName + " at " + loopAge + " is " + salary + ".\n");	
			if (seniority<35){
			   seniority+=5;
			} else {
				bw.write("Maximum salary reached.");
				break;
			}
	     }
		 bw.close();
		 System.out.println(fileName + " was created");
	}

	
	public String toString(){
		return firstName + " " + lastName + "(" + age + " years old).";
	}
	
}