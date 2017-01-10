package org.leecode;

public class Backpack_II {
	//Given n items with size Ai and value Vi, and a backpack with size m. 
	//What's the maximum value can you put into the backpack?
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        //corner case
        if (A == null || A.length == 0 || m <=0)
            return 0;
        int[] f = new int[m + 1];
        
        
        for (int i = 0; i < A.length; i++){
            for (int j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
}
