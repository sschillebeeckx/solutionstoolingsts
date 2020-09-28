package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

import be.abis.courseadmin.exception.AgeCannotBeNegativeException;

public class Instructor implements Comparable<Instructor>{
	
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private int startAge;
	private double startSalary;
	
	public Instructor(String firstName,String lastName,LocalDate birthDay,int startAge,double startSalary) throws AgeCannotBeNegativeException{
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDay=birthDay;
		this.setStartAge(startAge);
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
	
	public void setBirthday(LocalDate birthDay){
		this.birthDay=birthDay;	  
	}
	
	public LocalDate getBirthday(){
		return birthDay;
	}
	
	
	public int getStartAge(){
		return startAge;
	}
	
	public void setStartAge(int startAge) throws AgeCannotBeNegativeException{
		if (startAge>0){
		  this.startAge=startAge;
		} else {
		  throw new AgeCannotBeNegativeException("age cannot be negative");
	  }
	}
	
	public void setStartSalary(double startSalary){
		this.startSalary=startSalary;
	}
	
	public double getStartSalary(){
		return startSalary;
	}
	
	public void printSalaryHistory() throws IOException{

		 BufferedWriter bw = Files.newBufferedWriter(Paths.get("salaryhistory.txt"));
		 this.doPrinting(bw);
		 bw.close();
         System.out.println("salaryhistory.txt was created");
	}
	
	public void printSalaryHistory(String fileName) throws IOException{
		 
		 BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName));
		 this.doPrinting(bw);
		 bw.close();
		 System.out.println(fileName + " was created");
	}
	
	public void doPrinting(BufferedWriter bw)throws IOException{
		int seniority =0;		 
		 double salary=startSalary;
		 int age = this.calculateAge();
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
		 
	}
	
	public String toString(){
		return firstName + " " + lastName + "(" + this.calculateAge() + " years old).";
	}
	
	public int calculateAge(){
		return Period.between(birthDay,LocalDate.now()).getYears();
	}
	
	public int compareTo(Instructor other){
		return this.firstName.compareTo(other.firstName);
	}
}