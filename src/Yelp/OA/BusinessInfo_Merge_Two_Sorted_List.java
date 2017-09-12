package Yelp.OA;

import java.util.ArrayList;
import java.util.List;

/**
 * 给两个List<BusinessInfo>，class BusinessInfo{int id; int numReviews}，按照NumReviews descending sort merge两个list
 * @author Xue
 *
 */
public class BusinessInfo_Merge_Two_Sorted_List {

	public static void main(String[] args) {
		List<BusinessInfo> list1 = new ArrayList<BusinessInfo>();
		List<BusinessInfo> list2 = new ArrayList<BusinessInfo>();
		list1.add(new BusinessInfo(0, 900));
		list1.add(new BusinessInfo(1, 850));
		list1.add(new BusinessInfo(1, 800));
		list2.add(new BusinessInfo(0, 830));
		list2.add(new BusinessInfo(1, 820));
		list2.add(new BusinessInfo(1, 790));
		
		List<BusinessInfo> res = merge(list1, list2);
		for (BusinessInfo buss : res){
			System.out.print(buss.id);
			System.out.print(":");
			System.out.print(buss.rating);
			System.out.println("");
		}
	}
	
	private static List<BusinessInfo> merge(List<BusinessInfo> list1, List<BusinessInfo> list2){
		int m = list1.size(), n = list2.size();
		List<BusinessInfo> res = new ArrayList<BusinessInfo>(m+n);
		int i = 0, j = 0;
		while(i < m && j < n){
			if(list1.get(i).rating > list2.get(j).rating){
				res.add(list1.get(i));
				i++;
				}else{
					res.add(list2.get(j));
					j++;
				}
		}
		while(i < m){
			res.add(list1.get(i));
			i++;
		}
		while(j < n){
			res.add(list2.get(j));
			j++;
		}
		//Collections.reverse(res);
		return res;
		
		
	}

}
