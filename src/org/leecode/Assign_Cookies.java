package org.leecode;

import java.util.Arrays;

public class Assign_Cookies {
	//贪婪算法，我们可以首先对两个数组进行排序，让小的在前面。然后我们先拿最小的cookie给胃口最小的小朋友，
    //看能否满足，能的话，我们结果res自加1，然后再拿下一个cookie去满足下一位小朋友；
    //如果当前cookie不能满足当前小朋友，那么我们就用下一块稍大一点的cookie去尝试满足当前的小朋友。
    //当cookie发完了或者小朋友没有了我们停止遍历
    public int findContentChildren(int[] g, int[] s) {
        //corner case
        if (g == null || g.length == 0 || s == null || s.length == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if (g[i] <= s[j]){
                res++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return res;
    }
}
