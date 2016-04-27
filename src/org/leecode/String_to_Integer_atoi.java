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
}
