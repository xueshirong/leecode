package zillow;

import java.lang.reflect.Field;
import java.util.*;

class Person {
	String ssn;
	Date dateOfBirth;
	String firstName;
	String lastName;
	Double heightIn;
	Double weightLb;
}

public class zillow_sort {
	/*
	 * Sort list of Person base on specific field
	 * 0. Colletions.sort use merge sort as default sort method. Here QuickSort are implemented because the sort of Person is unstable.
	 * 1. In QuickSort, we sort the list in ascending. if ascending = false, reverse the list out of QuickSort.
	 * 2. We also can sort the list both in ascending and in descending order in QuickSort methon, considering of the readbility and 
	 * maintainability, I implement the QuickSort in ascending order only.
	 * 3. The sort rules are as follow:
	 * 3.1 ssn is independent to other attributes, because ssn are unique value.
	 * 3.2 dateOfBirth, firstName and lastName are dependent group. There are duplicate value. 
	 * Example： if dateOfBirth is same, then compare last name, then compare first name.
	 * 3.3 heightIn and weightLb are dependent to each other. There are duplicate value. person A's heightIn may equal to person B's heightIn.
	 * Example： if heightIn is equal, then compare weightLb.
	 */
	public List<Person> sort(Iterable<Person> people, String sortField, String ascending) {
		List<Person> result = new ArrayList<Person>();	

		// 1. Using for-each loop to add element to list instead of Iterator because we do not modify collection
		for (Person person : people) {
			result.add(person);
		}
		
		// 2. corner case		
		if (result.size() == 0)// Iterable is empty
			return result;

		if (ascending.toLowerCase() != "true" && ascending.toLowerCase() != "false")// ascending is invalid
			return result;

		if (!validSortField(new Person(), sortField))// sortField is not the property of Person class
			return result;

		// 3. QuickSort the list according to the sortField in ascending order
		quickSort(result, sortField, ascending, 0, result.size() - 1);

		// 4. return result
		if (ascending == "false")//if the ascending = false, then reverse the list.
			Collections.reverse(result);
		
		return result;
	}

	/*
	 * valid sortField is one of the property of Person class
	 * return. true:sortField belong to Person class. false:sortField do not belong to Person class
	 */
	private boolean validSortField(Person p, String sortField) {
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
	private void quickSort(List<Person> result, String sortField, String ascending, int start, int end) {
		if (start >= end)
			return;
		int pos = partition(result, sortField, start, end);
		quickSort(result, sortField, ascending, start, pos - 1);
		quickSort(result, sortField, ascending, pos + 1, end);
	}

	/*
	 * Partition of QuickSort. Sort the list in ascending order.
	 * Using swithc- case to sort 6 attributes seperatly instead of 6 sub-function because of the code readbility and maintainability.
	 * Considering of readbility and maintainability, multiple if-else are used to check the sort priority.
	 * The priority rules are as follow if there the values are equaled:
	 * 1. ssn is independent to other attributes.
	 * 2. The priority of dateOfBirth, lastName and firstName: dateOfBirth > lastName > firstName.
	 * 3. The priority of lastName, firstName and dateOfBirth: lastName > firstName > dateOfBirth.
	 * 4. The priority of firstName, lastName and dateOfBirth: firstName > lastName > dateOfBirth.
	 * 5. The priority of heightIn and weightLb: heightIn > weightLb
	 */
	private int partition(List<Person> list, String sortField, int start, int end) {
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
					if (pi.weightLb.compareTo(pEnd.weightLb) < 0) {
						Collections.swap(list, i, pos++);
					}else if (pi.weightLb.compareTo(pEnd.weightLb) == 0){
						if (pi.heightIn.compareTo(pEnd.heightIn) < 0){//sort heightIn if weightLb is same
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