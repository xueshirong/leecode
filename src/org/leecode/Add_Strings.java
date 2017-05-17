package org.leecode;

public class Add_Strings {
	//add 2 big float
	public String addStrings1(String num1, String num2){
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
	
    //sb.insert is slower than sb.reverse
    public String addStrings(String num1, String num2) {
        if (num1 == "") return num2;
        if (num2 == "") return num1;
        int alen = num1.length() - 1, blen = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (alen > -1 || blen > -1 || carry != 0){
            if (alen > -1){
                carry += num1.charAt(alen) - '0';
                alen--;
            }
            if (blen > -1){
                carry += num2.charAt(blen) - '0';
                blen--;
            }
            sb.insert(0, carry % 10);
            carry = carry / 10;
        }
        return sb.toString();
    }
}
