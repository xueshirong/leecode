package org.leecode.Sabre;

import java.util.HashMap;
import java.util.Map;

public class MyClass {
	private static int number;
	
	public static void main(String... args){
		
		
		//System.out.println(getStringValue(number));
		
		/*Map<City, String> map = new HashMap<>();		
		
		City city1 = new City("krakow");
		City city2 = new City("krakow");
		City city3 = new City("warszawa");
		map.put(city1, "Etiuda i anima");
		map.put(city2, "Wianki");
		map.put(city3, "Wislostrada");
		
		System.out.println(map.size());*/
		
		/*String name = "I can do this!";
		name.replace("can", "cannot");
		name.replaceAll("can.*", "will");
		System.out.println(name);*/
	}	
	
	private static String getStringValue(Integer number){
		return String.valueOf(number);
	}

	
	
	
	void yield(){
		int a=1, b=2, c=1;
		if (a == b || b ==c){
			
		}
	}
}
class City{
	String name;
	
	City(String n){
		name = n;
	}
	public boolean equals(Object obj){
		return ((City)obj).name == this.name;
	}
	/*public int hashCode(){
		return -1;
	}*/
}