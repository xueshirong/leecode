package Yelp.OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BusinessInfo_Median {

	public static void main(String[] args) {
		List<BusinessInfo> input = getTestData();
		double output = findBusinessesMedian(input);
		System.out.println(output);
		/*for (BusinessInfo buss : output){
			System.out.print(buss.id);
			System.out.print(":");
			System.out.print(buss.rating);
			System.out.println("");
		}*/
	}
	
	public static double findBusinessesMedian(List<BusinessInfo> businesses){
		Collections.sort(businesses, new Comparator<BusinessInfo>() {
			public int compare(BusinessInfo a, BusinessInfo b) {
				return b.rating - a.rating;
			}
		});	
		
		int size = businesses.size();
		if (size % 2 == 0){
			return (businesses.get(size / 2).rating + businesses.get(size / 2 - 1).rating) / 2.0;
		}else{
			return businesses.get(size / 2).rating;
		}
	}
	
	private static List<BusinessInfo> getTestData() {
		List<BusinessInfo> list = new ArrayList<BusinessInfo>();
		list.add(new BusinessInfo(101, 5));
		list.add(new BusinessInfo(102, 4));
		list.add(new BusinessInfo(103, 3));
		list.add(new BusinessInfo(104, 2));
		list.add(new BusinessInfo(105, 1));
		return list;
	}

}
