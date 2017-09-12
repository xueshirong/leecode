package Yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class BusinessInfo {
    int id;
    int rating;

    public BusinessInfo(int id, int rating){
        this.id = id;
        this.rating = rating;
    }
}

public class BusinessInfo_Sort {
	/**
     * List of bussinesses info where each element is a dictionary containing
     * id and rating. Sort the businesses by their rating in decreasing order.
     * Preserve the original ordering if two businesses have same rating.
     *
     * @param businesses List of BusinessInfo objects where BusinessInfo
     * is a class containing id and rating.
     *
     * @return List of BusinessInfo sorted by rating in decreasing order
     *
     * Example input:
     * [
     *     {'id': 101, rating: 5},
     *     {'id': 102, rating: 2},
     *     {'id': 103, rating: 3},
     *     {'id': 104, rating: 5},
     *     {'id': 105, rating: 5},
     * ]
     * Expected output:
     * [
     *     {'id': 101, rating: 5},
     *     {'id': 104, rating: 5},
     *     {'id': 105, rating: 5},
     *     {'id': 103, rating: 3},
     *     {'id': 102, rating: 2},
     * ]
     */

	public static void main(String[] args) {
		List<BusinessInfo> input = getTestData();
		List<BusinessInfo> output = sortBusinessesByRating(input);
		for (BusinessInfo buss : output){
			System.out.print(buss.id);
			System.out.print(":");
			System.out.print(buss.rating);
			System.out.println("");
		}
	}
	
	public static List<BusinessInfo> sortBusinessesByRating(List<BusinessInfo> businesses){
		Collections.sort(businesses, new Comparator<BusinessInfo>() {
			public int compare(BusinessInfo a, BusinessInfo b) {
				return b.rating - a.rating;
			}
		});	
		
		return businesses;
	}
	
	private static List<BusinessInfo> getTestData() {
		List<BusinessInfo> list = new ArrayList<BusinessInfo>();
		list.add(new BusinessInfo(101, 5));
		list.add(new BusinessInfo(102, 2));
		list.add(new BusinessInfo(103, 3));
		list.add(new BusinessInfo(104, 5));
		list.add(new BusinessInfo(105, 5));
		return list;
	}
}
