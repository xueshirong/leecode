package org.leecode;

public class First_Missing_Positive {
	//虽然不能再另外开辟非常数级的额外空间，但是可以在输入数组上就地进行swap操作.
    //交换数组元素，使得数组中第i位存放数值(i+1)。
    //最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int i = 0;
        while (i < nums.length){
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length &&  nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        
        i = 0;
        while (i < nums.length){
            if (nums[i] != i + 1)
                return i + 1;
            else
                i++;
        }
        return nums.length + 1;
    }
    //1 排序之后查找  O(n), extra space
    //2 把出现的数值放到与下标一致的位置，再判断什么位置最先出现不连续的数值，就是答案了。O(n), extra space
}
