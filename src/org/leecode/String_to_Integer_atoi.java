package org.leecode;

public class String_to_Integer_atoi {
	//corner cases. 1. leading zero. 2. leading +/-. 3. invalid char. 4. overflow
    public int myAtoi(String str) {
    	//1. trim leading zero
        str = str.trim();
        if (str.equals(""))  return 0;
        //2. +/-
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '-'){
            i++;
            sign = -1;
        }else if (str.charAt(0) == '+'){
            i++;
        }
        
        int res = 0;
        for (; i < str.length(); i++){
            int c = str.charAt(i) - '0';
            if (c < 0 || c > 9)
                break;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && c > 7)){
                if (sign == 1)  return Integer.MAX_VALUE;
                else    return Integer.MIN_VALUE;
            }
            
            res = res * 10 + c;
        }
        return res * sign;
    }
    
	//solution 3
	//note + - 号，溢出，以及非数字
	public int myAtoi3(String str) {
        str = str.trim();
        if (str.equals(""))
            return 0;
        long res = 0;
        int i = 0;
        int mark = 1;
        
        if (str.charAt(i) == '+')
            i++;
        else if (str.charAt(i) == '-'){
            i++;
            mark = -1;
        }
        
        for (; i < str.length(); i++){
            char c = str.charAt(i);
            if (!Character.isDigit(c))
                break;
            res = res * 10 + (c - '0');
            
            if (mark * res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            
            if (mark * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)(mark * res);
    }
}
