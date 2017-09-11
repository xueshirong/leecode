package Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BussinessCategory{
    int id;
    List<String> category;
    public BussinessCategory(int i, List<String> list){
    	id = i;
    	category = list;
    }
}

/**
 * 给一个 bussinessInfo 的类，里面有id 和catagory, 是这样： class bussinessInfo{int id, String catagory}
 * 输入： 101 japanese, sushi, resturant
           102 japanese, seafood
           103 japanese, resturant, ramen
        输出： 101, 103 即找出所有的id 即是 japanese 又是resturant
 * @author Xue
 *
 */
public class BussinessInfo_Category {

	public static void main(String[] args) {
		List<BussinessCategory> list = new ArrayList<BussinessCategory>();
		list.add(new BussinessCategory(101, new ArrayList<>(Arrays.asList("japanese", "sushi", "resturant"))));
		list.add(new BussinessCategory(102, new ArrayList<>(Arrays.asList("japanese", "sushi", "Dinner", "resturant"))));
		list.add(new BussinessCategory(103, new ArrayList<>(Arrays.asList("Chinese", "Sichuan", "Dinner", "Bar"))));
		list.add(new BussinessCategory(104, new ArrayList<>(Arrays.asList("japanese", "Breakfirst"))));
		List<Integer> res = find(list, "japanese", "Breakfirst");
		for (Integer i : res){
			System.out.println(i);
		}
	}
	
	public static List<Integer> find(List<BussinessCategory> s, String A, String B){
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < s.size(); i++){
			if(s.get(i).category.contains(A) && s.get(i).category.contains(B)){
				res.add(s.get(i).id);
			}
		}
		return res;
	}
}
