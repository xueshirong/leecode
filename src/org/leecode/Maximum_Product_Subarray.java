package org.leecode;

public class Maximum_Product_Subarray {
	//DP: 以A[i]结尾的max product subarray同时取决于以A[i-1]结尾的max / min product subarray以及A[i]本身。
    //因此，对每个i，需要记录min/max product两个状态：

    //max_product[i] = max(max_product[i-1]*A[i], min_product[i-1]*A[i], A[i]) 
    //min_product[i] = min(max_product[i-1]*A[i], min_product[i-1]*A[i], A[i]) 
    public int maxProduct(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0)
            return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            min[i] = max[i] = nums[i];//key point
            if (nums[i] > 0){
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            }else{
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
    
    public int maxProduct1(int A[], int n) {
        if(n<=0) return 0;
        int ret, curMax, curMin;
        ret = curMax = curMin = A[0];
        for(int i=1; i<n; i++) {
            int temp = curMax;
            curMax = Math.max(Math.max(curMax*A[i], curMin*A[i]),A[i]);
            curMin = Math.min(Math.min(temp*A[i], curMin*A[i]),A[i]);
            ret = Math.max(ret, curMax);
        }
        return ret;
    }
}
