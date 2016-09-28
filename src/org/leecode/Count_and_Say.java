package org.leecode;

public class Count_and_Say {
	public String countAndSay(int n) {
		if (n <= 0)
            return "";
        StringBuilder sb = new StringBuilder();
        String res = "1";
        for(int k = 1; k < n; k++){
            int temp = 1;
            sb = new StringBuilder();
	        for (int i = 0; i < res.length(); i++){                
	        	if (i < res.length() - 1 && res.charAt(i) == (res.charAt(i + 1))){
	                temp++;
	            }else{
	                sb.append(String.valueOf(temp) + res.charAt(i));
	                temp = 1;
	            }
	        }
	        res = sb.toString();
        }
        return res;
    }
	
	public String countAndSay2(int n) {
        if (n < 1)
            return "";
        String s = "1";
        for (int i = 1; i < n; i++){
            String temp = "";
            int count = 1;
            for (int j = 0; j < s.length(); j++){
                if (j < s.length()-1 && s.charAt(j) == s.charAt(j - 1))
                    count++;
                else{
                    temp += String.valueOf(count) + String.valueOf(s.charAt(j));
                    count = 1;
                }
            }
            s = temp;
        }
        return s;
    }
}
