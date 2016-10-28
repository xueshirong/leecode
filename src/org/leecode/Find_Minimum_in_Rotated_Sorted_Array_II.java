package org.leecode;

public class Find_Minimum_in_Rotated_Sorted_Array_II {
	/**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
	//The array may contain duplicates.
	//  这道题目在面试中不会让写完整的程序
    //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
    //  这种情况使得时间复杂度必须是 O(n)
    //  因此写一个for循环就好了。
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0)
            return -1;
        int s = 0, e = num.length - 1;
        while (s + 1 < e){
            int mid = s + (e - s)/2;
            if (num[mid] > num[e])
                s = mid;
            else if (num[mid] == num[e])//When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let upper bound reduce one.
                e--;
            else
                e = mid;
        }
        if (num[s] < num[e])
            return num[s];
        else
            return num[e];
    }
}
