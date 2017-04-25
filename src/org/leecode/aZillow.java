package org.leecode;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Person {
	String ssn;
	Date dateOfBirth;
	String firstName;
	String lastName;
	Double heightIn;
	Double weightLb;
}

public class aZillow {
	public static void main(String[] args) {
		Iterable<Person> input = getTestData();
		System.out.println("The input is:");
		printList(input);
		List<Person> res = sort(input, "weightLb", "true");
		System.out.println("The output is:");
		printList(res);
	}

	// print list to console
	private static void printList(Iterable<Person> input) {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		for (Person p : input) {
			System.out.print(p.ssn + " ");
			System.out.print(df.format(p.dateOfBirth) + " ");
			System.out.print(p.firstName + " ");
			System.out.print(p.lastName + " ");
			System.out.print(p.heightIn + " ");
			System.out.println(p.weightLb + " ");
		}
	}

	// get test data
	static Iterable<Person> getTestData() {
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
		res.add(generatePerson("", "04/06/1980",
				"Servi", "Cinner", 195.8, 90.4));
		res.add(generatePerson(String.valueOf(ThreadLocalRandom.current().nextInt(100000001, 1000000000)), "04/06/1987",
				"Tservi", "Cinner", 195.8, 90.4));
		return res;
	}

	// generate Person object
	private static Person generatePerson(String ssn, String dateOfBirth, String firstName, String lastName, Double heightIn, Double weightLb) {
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

	/*
	 * Sort list of Person base on specific field
	 */
	static List<Person> sort(Iterable<Person> people, String sortField, String ascending) {
		List<Person> result = new ArrayList<Person>();

		// 1. check corner case
		Iterator<Person> it = people.iterator();
		if (!it.hasNext())// Iterable is empty
			return result;
		
		if (ascending.toLowerCase() != "true" && ascending.toLowerCase() != "false")// ascending is invalid 
			return result;
		
		if (!validSortField(new Person(), sortField))//sortField is not the property of Person class
			return result;
		

		// 2. Using for-each loop to add element to list instead of Iterator because we do not modify collection
		for (Person person : people) {
			result.add(person);
		}

		// 3. QuickSort the list according to the sortField
		quickSort(result, sortField, ascending, 0, result.size() - 1);

		// 4. return result
		/*if (ascending == "false")
			Collections.reverse(result);*/
		
		return result;
	}

	/*
	 * valid sortField is one of the property of Person class
	 */
	private static boolean validSortField(Person p, String sortField) {
		Class<?> c = p.getClass();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().toString() == sortField)
				return true;
		}
		return false;
	}

	/*
	 * QuickSort of Person List
	 */
	private static void quickSort(List<Person> result, String sortField, String ascending, int start, int end) {
		if (start >= end)
			return;
		int pos = partition(result, sortField, start, end);
		quickSort(result, sortField, ascending, start, pos - 1);
		quickSort(result, sortField, ascending, pos + 1, end);
	}

	/*
	 * Partition of QuickSort 
	 * 1. if the value of sortField is empty, what will happen
	 */
	private static int partition(List<Person> list, String sortField, int start, int end) {
		Random rad = new Random();
		Collections.swap(list, start + rad.nextInt(100) % (end - start + 1), end);
		int pos = start;
		for (int i = start; i < end; i++) {
			Person pi = (Person) list.get(i);
			Person pEnd = (Person) list.get(end);
			switch(sortField){
				case "dateOfBirth":{//sort dateOfBirth
					if (pi.dateOfBirth.compareTo(pEnd.dateOfBirth) < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.dateOfBirth.compareTo(pEnd.dateOfBirth) == 0){
						if (pi.lastName.compareTo(pEnd.lastName) < 0){//sort last name if dateOfBirth is same
							Collections.swap(list, i, pos++);
						}else if (pi.lastName.compareTo(pEnd.lastName) == 0){
							if (pi.firstName.compareTo(pEnd.firstName) < 0){//sort firt name if last name is same
								Collections.swap(list, i, pos++);
							}
						}
					}
					break;
				}
				case "lastName": {//sort lastName
					if (pi.lastName.compareTo(pEnd.lastName) < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.lastName.compareTo(pEnd.lastName) == 0){
						if (pi.firstName.compareTo(pEnd.firstName) < 0){//sort first name if last name is same
							Collections.swap(list, i, pos++);
						}else if (pi.firstName.compareTo(pEnd.firstName) == 0){
							if (pi.dateOfBirth.compareTo(pEnd.dateOfBirth) < 0){//sort dateOfBirth if last and last name are same
								Collections.swap(list, i, pos++);
							}
						}
					}
					break;
				}
				case "firstName": {//sort firstName
					if (pi.firstName.compareTo(pEnd.firstName) < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.firstName.compareTo(pEnd.firstName) == 0){
						if (pi.lastName.compareTo(pEnd.lastName) < 0){//sort last name if firt name is same
							Collections.swap(list, i, pos++);
						}else if (pi.lastName.compareTo(pEnd.lastName) == 0){
							if (pi.dateOfBirth.compareTo(pEnd.dateOfBirth) < 0){//sort dateOfBirth if last and last name are same
								Collections.swap(list, i, pos++);
							}
						}
					}
					
					break;
				}
				case "heightIn": {//sort heightIn
					if (pi.heightIn.compareTo(pEnd.heightIn) < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.heightIn.compareTo(pEnd.heightIn) == 0){
						if (pi.weightLb.compareTo(pEnd.weightLb) < 0){//sort weightLb if heightIn is same
							Collections.swap(list, i, pos++);
						}
					}
					break;
				}
				case "weightLb": {//sort weightLb
					if (pi.weightLb.compareTo(pEnd.weightLb) * -1 < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.weightLb.compareTo(pEnd.weightLb) == 0){
						if (pi.heightIn.compareTo(pEnd.heightIn) * -1 < 0){//sort heightIn if weightLb is same
							Collections.swap(list, i, pos++);
						}
					}
					break;
				}				
				default:{//default sort field is "ssn"
					if (pi.ssn.compareTo(pEnd.ssn) < 0)
						Collections.swap(list, i, pos++);
				}
			}			
		}
		Collections.swap(list, pos, end);
		return pos;
	}
}