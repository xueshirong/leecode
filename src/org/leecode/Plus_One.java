package org.leecode;

import java.util.Arrays;

public class Plus_One {
	public int[] plusOne(int[] digits) {
        Integer tem = 0;
        for (int i = digits.length-1; i > -1; i--){//loop from back to front
            tem = (digits[i] + 1)/10;
            digits[i] = (digits[i] + 1)%10;
            if (tem == 0)
                return digits;//After plus one, the value less than 10, then stop. no need continue to loop.
        }
        int[] results = new int[digits.length + 1];//If the (first digit + 1) > 10, then use new array to set 1000...
        Arrays.fill(results, 0);
        results[0] = 1;
        return results;
    }
}
