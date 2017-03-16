package org.leecode;

public class Add_Strings {
	//add 2 big float
	public String addStrings(String num1, String num2){
        int m = num1.length() - 1, n = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int mpoint = m - num1.indexOf(".");
        int npoint = n - num2.indexOf(".");
        if (mpoint > npoint){
            sb.append(num1.charAt(m));
            m--;
            mpoint = m - num1.indexOf(".");
        }
        if (npoint > mpoint){
            sb.append(num2.charAt(n));
            n--;
            npoint = n - num2.indexOf(".");
        }
        
        int carry = 0;
        while (m >= 0 || n >=0){
            if (num1.charAt(m) == '.'){
                sb.append(".");
                m--;
                n--;
                continue;
            }
        
            int sum = carry;
            if (m >= 0){
                sum += num1.charAt(m) - '0';
                m--;
            }
            if (n >= 0){
                sum += num2.charAt(n) - '0';
                n--;
            }
            sb.append(sum%10);
            carry = sum/10;
        }        
        return sb.reverse().toString();
	}
	
	//add 2 big int
    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1, n = num2.length() - 1;
        int carry = 0;
        while (m >=0 || n >= 0){
            int sum = carry;
            if (m >= 0){
                sum += num1.charAt(m) - '0';
                m--;
            }
            if (n >= 0){
                sum += num2.charAt(n) - '0';
                n--;
            }
            carry = sum/10;
            sb.append(sum%10);
        }
        if (carry == 1)
            sb.append(1);

        return sb.reverse().toString();
    }
	
	public String addStrings1(String num1, String num2) {
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
