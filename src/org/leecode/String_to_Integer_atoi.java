package org.leecode;

public class String_to_Integer_atoi {
	public int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        boolean isSign = false;
        boolean isDecimal = false;
        str = str.trim();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '-'){//check minus sign
                if (isSign)
                    return 0;
                isSign = true;
                sign = -1;
                continue;
            }else if (c == '+'){
                if (isSign)
                    return 0;
                isSign = true;
            	continue;
            }else if (c == '.'){//check point
                isDecimal = true;
                continue;
            }else if (c >= '0' && c <= '9'){//check digit
                if (isDecimal){
                    res = res + Integer.parseInt(String.valueOf(c))/10;
                }else{
                	if (sign * (res + Integer.parseInt(String.valueOf(c))) >= Integer.MAX_VALUE/10 + 7){
                		return Integer.MAX_VALUE;
                	}else if (sign * (res + Integer.parseInt(String.valueOf(c))) <= Integer.MIN_VALUE/10 - 8){
                		return Integer.MIN_VALUE;
                	}else{
                		res = res * 10 + Integer.parseInt(String.valueOf(c));
                	}
                }
            }else{//if it is a invalid char, break and return previous value
                break;
            }
        }
        return sign * res;
	}
	
	//09/03/2013
	public int myAtoi2(String str) {
		str = str.trim();//remove blank space
        long res = 0;
        int sign = 1;//use long to store result, then convert to int at the end
        for (int i = 0; i < str.length(); i++){
            if (i == 0 && str.charAt(i) == '-'){//check positive or negative
                sign = -1;
                continue;
            }else if (i == 0 && str.charAt(i) == '+'){
                continue;
            }
            
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){//check if digit
                res = res * 10 + (str.charAt(i) - '0');
                if (sign * res > Integer.MAX_VALUE){//check if outflow
                    res = Integer.MAX_VALUE;
                    return Integer.MAX_VALUE;
                }
                else if (sign * res < Integer.MIN_VALUE){
                    res = Integer.MIN_VALUE;
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        
        res = sign * res;
        return (int)res;
    }
	
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
