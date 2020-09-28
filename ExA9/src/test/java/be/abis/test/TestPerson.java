package be.abis.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import be.abis.exa8.model.Person;

public class TestPerson {


	@Test
	public void testCalculateAge() {
		Person p2 = new Person(2,"John","Doe",LocalDate.of(1967, 8, 10));
		assertEquals(p2.calculateAge(),53);
	}

}
