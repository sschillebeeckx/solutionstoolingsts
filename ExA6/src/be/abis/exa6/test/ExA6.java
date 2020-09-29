package be.abis.exa6.test;

import be.abis.exa6.model.Address;
import be.abis.exa6.model.Company;
import be.abis.exa6.model.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ExA6 {

	public static void main(String[] args) {
      
       Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","België","BE");
       Company c = new Company("ABIS",a);
       
       Person p1 = new Person(1,"Ann","Smits",LocalDate.of(1985, 6, 28),c);
       Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
       
       System.out.println(p1);
       System.out.println(p2);
       
       try ( BufferedWriter bw = Files.newBufferedWriter(Paths.get("personinfo.txt"));){
    	   bw.write(p1 + "\n");
    	   bw.write(p2 + "\n"); 
    	   System.out.println("persons written to file");
       } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       

	}

}
