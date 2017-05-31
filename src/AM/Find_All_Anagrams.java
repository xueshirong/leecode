package AM;

import java.util.*;

public class Find_All_Anagrams {
	public static void main(String[] args) {
		List<Integer> res = findAnagrams("cbaebabacd", "abc");
		System.out.print(res);
	}
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList <Integer>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) 
			return ans;
		//record each character in p to array
        int[] arr = new int[30];

        int plength = p.length();
        int slength = s.length();
        
        for(char c : p.toCharArray()){
        	arr[c - 'a'] ++;
        }
        //two points
        int start = 0;
        int end = 0;
        int matched = 0;
        while(end < slength){
        	//if char is in p, then matched increase 1
            if(arr[s.charAt(end) - 'a'] >= 1){
                matched ++;
            }
            
            arr[s.charAt(end) - 'a'] --;
            end ++;//move right every time
            
            if(matched == plength) {//get the correct anagram
                ans.add(start);//add to result
            }
            
            if(end - start == plength){
                if(arr[s.charAt(start) - 'a'] >= 0){//>=0 means the left char is in p
                    matched --;
                }
                arr[s.charAt(start) - 'a'] ++;
                start ++;//narrow the window by moving start to right
            }
        }
        return ans;
    }
}
