package org.leecode;

public class Search_in_a_Big_Sorted_Array {
	/*Given a big sorted array with positive integers sorted by ascending order. 
	The array is so big so that you can not get the length of the whole array directly, 
	and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). 
	Find the first index of a target number. Your algorithm should be in O(log k), 
	where k is the first index of the target number.
	Return -1, if the number doesn't exist in the array.*/	
	
	class ArrayReader {
		// get the number at index, return -1 if index is less than zero.
		public int get(int index){
			return index;
		}
	}
	/**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int index = 1;
        while(reader.get(index) < target){//find the index which is greater than target
            index = index * 2;
        }
        
        int s = 0;
        int e = index;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (reader.get(mid) == target)
                e = mid;
            else if (reader.get(mid) > target)
                e = mid;
            else
                s = mid;
        }
        if (reader.get(s) == target)
            return s;
        else if (reader.get(e) == target)
            return e;
        return -1;
    }
}
