package zillow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class zillow_sortTest {
	zillow_sort sortObj = new zillow_sort();
	@Test
	public void testSort() {
		Iterable<Person> people = getTestData();
		System.out.println("The input is:");
		printList(people);
		List<Person> result = new ArrayList<Person>();
		//ssn ascending = true
		result = sortObj.sort(people, "ssn", "true");
		System.out.println("The output of SSN in ASC:");
		printList(result);
		//ssn ascending = false
		result = sortObj.sort(people, "ssn", "false");
		System.out.println("The output of SSN in DESC:");
		printList(result);
		
		//dateOfBirth ascending = true
		result = sortObj.sort(people, "dateOfBirth", "true");
		System.out.println("The output of dateOfBirth in ASC:");
		printList(result);
		//dateOfBirth ascending = false
		result = sortObj.sort(people, "dateOfBirth", "false");
		System.out.println("The output of dateOfBirth in DESC:");
		printList(result);
		
		//firstName ascending = true
		result = sortObj.sort(people, "firstName", "true");
		System.out.println("The output of firstName in ASC:");
		printList(result);
		// firstName ascending = false
		result = sortObj.sort(people, "firstName", "false");
		System.out.println("The output of firstName in DESC:");
		printList(result);
		
		//lastName ascending = true
		result = sortObj.sort(people, "lastName", "true");
		System.out.println("The output of lastName in ASC:");
		printList(result);
		// lastName ascending = false
		result = sortObj.sort(people, "lastName", "false");
		System.out.println("The output of lastName in DESC:");
		printList(result);
		
		//heightIn ascending = true
		result = sortObj.sort(people, "heightIn", "true");
		System.out.println("The output of heightIn in ASC:");
		printList(result);
		// heightIn ascending = false
		result = sortObj.sort(people, "heightIn", "false");
		System.out.println("The output of heightIn in DESC:");
		printList(result);
		
		//weightLb ascending = true
		result = sortObj.sort(people, "weightLb", "true");
		System.out.println("The output of weightLb in ASC:");
		printList(result);
		// weightLb ascending = false
		result = sortObj.sort(people, "weightLb", "false");
		System.out.println("The output of weightLb in DESC:");
		printList(result);
	}
	
	// get test data
	private Iterable<Person> getTestData() {
		List<Person> res = new ArrayList<Person>();
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/06/1987",
				"Servi", "Domina", 178.8, 89.2));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "02/19/1988",
				"Sandi", "Dong", 177.8, 90.6));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/06/1986",
				"Arthur", "Hinner", 195.8, 97.5));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/15/1987",
				"Sylvia", "Reyes", 170.8, 60.5));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/06/1987",
				"Servi", "Cinner", 195.8, 97.5));
		res.add(generatePerson("", "04/06/1980", "Servi", "Cinner", 195.8, 90.4));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/06/1987",
				"Tservi", "Cinner", 195.8, 90.4));
		return res;
	}
	
	// generate Person object
	private Person generatePerson(String ssn, String dateOfBirth, String firstName, String lastName,
			Double heightIn, Double weightLb) {
		Person person = new Person();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		person.ssn = ssn;
		try {
			person.dateOfBirth = df.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		person.firstName = firstName;
		person.lastName = lastName;
		person.heightIn = heightIn;
		person.weightLb = weightLb;

		return person;
	}
	
	// print list to console
	private void printList(Iterable<Person> input) {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		for (Person p : input) {
			System.out.print(p.ssn + " ");
			System.out.print(df.format(p.dateOfBirth) + " ");
			System.out.print(p.firstName + " ");
			System.out.print(p.lastName + " ");
			System.out.print(p.heightIn + " ");
			System.out.println(p.weightLb + " ");
		}
		System.out.println();
	}
}
