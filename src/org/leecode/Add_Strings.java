package org.leecode;

public class Add_Strings {
	public String addStrings(String num1, String num2) {
        String res = "";
        int flag = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        for (; i > -1  && j > -1; i--, j--){
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            if (c1 + c2 + flag >= 10){
                res = String.valueOf(c1 + c2 + flag - 10) + res;
                flag = 1;
            }else{
                res = String.valueOf(c1 + c2 + flag) + res;
                flag = 0;
            }
        }
        while (i > -1){
            int c1 = num1.charAt(i) - '0';
            if (c1 + flag >= 10){
                res = String.valueOf(c1 + flag - 10) + res;
                flag = 1;
            }else{
                res = String.valueOf(c1 + flag) + res;
                flag = 0;
            }
            i--;
        }
        while (j > -1){
            int c2 = num2.charAt(j) - '0';
            if (c2 + flag >= 10){
                res = String.valueOf(c2 + flag - 10) + res;
                flag = 1;
            }else{
                res = String.valueOf(c2 + flag) + res;
                flag = 0;
            }
            j--;
        }
        if (flag == 1)
            res = "1" + res;
        return res;
    }
}
