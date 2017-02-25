package org.leecode;

public class Hamming_Distance {
	//思路：就是求x和y二进制的异或中的1的个数
    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        String s = Integer.toBinaryString(res);//key point. change Integer to binary string
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }
    
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        String s = Integer.toBinaryString(res);//key point. change Integer to binary string
        s = s.replaceAll("0", "");//key point: replaceAll
        return s.length();
    }
}
