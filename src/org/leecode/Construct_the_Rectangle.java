package org.leecode;

public class Construct_the_Rectangle {
	//思路：
	//(1)先求area的算术平方根取整end。
	//(2)用num记录长和宽的最小差值，从1到end遍历，若当前数i能被area整除，则记j为area / i，
	//再求j - i的差值，若比num小，则更新num，并记result为[i,j]。
	public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int end = (int)Math.sqrt(area);
        if (end * end == area){
            res[0] = end;
            res[1] = end;
            return res;
        }
        int dif = Integer.MAX_VALUE;
        for (int i = 1; i <= end; i++){//key point: <= end
            if (area % i == 0 && area / i - i < dif){
                dif = area / i - i;
                res[0] = area / i;
                res[1] = i;
            }
        }
        
        return res;
    }
}
