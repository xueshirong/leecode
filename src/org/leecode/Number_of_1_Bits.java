package org.leecode;

public class Number_of_1_Bits {
	// you need to treat n as an unsigned value
    //题目分析: 设输入的数为n，把n与1做二进制的与(AND)运算，即可判断它的最低位是否为1。
    //如果是的话，把计数变量加一。然后把n向右移动一位，重复上述操作。当n变为0时，终止算法，输出结果。
    //时间复杂度：O(n) 空间复杂度：O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){//should be !=, if use >, there will be overtime 
            count += n & 1;
            n = n >>> 1;//>>> is unsigned right move
        }
        return count;
    }
}
