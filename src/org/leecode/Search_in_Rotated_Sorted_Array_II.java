package org.leecode;

public class Search_in_Rotated_Sorted_Array_II {
	/*Follow up for Search in Rotated Sorted Array:
	  What if duplicates are allowed?
	  Would this affect the run-time complexity? How and why?
      Write a function to determine if a given target is in the array.*/
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0)
            return false;
            
        int s = 0, e = A.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (A[mid] == target)
                return true;
                
            if (A[s] == A[mid] && A[mid] == A[e]){
                s++; e--;
            }
            else if (A[s] <= A[mid]){
                if (A[s] <= target && target <= A[mid])
                    e = mid;
                else
                    s = mid;
            }
            else{
                if (A[mid] <= target && target <= A[e])
                    s = mid;
                else
                    e = mid;
            }
        }
        
        if (A[s] == target || A[e] == target)
            return true;
        return false;
    }
    
    // 这个问题在面试中不会让实现完整程序
    // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    // 在这种情况下是无法使用二分法的，复杂度是O(n)
    // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
            
        int s = 0, e = nums.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (nums[mid] == target)
                return true;
                
            if (nums[s] < nums[mid]){
                if (nums[s] <= target && target <= nums[mid])
                    e = mid;
                else
                    s = mid;
            }
            else if (nums[s] > nums[mid]){
                if (nums[mid] <= target && target <= nums[e])
                    s = mid;
                else
                    e = mid;
            }
            else//skip duplicate one, A[start] == A[mid]
                s++;
        }
        
        if (nums[s] == target || nums[e] == target)
            return true;
        return false;
    }
}
