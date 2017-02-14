package org.leecode;

import java.util.Arrays;

public class triangle_count {
	//loop + two pointer
	public int triangleCount(int S[]) {
        // write your code here
        int left = 0, right = S.length - 1;
        int ans = 0;
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while(left < right) {
                if(S[left] + S[right] > S[i]) {
                    ans = ans + (right - left);
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return ans;
    }
}
