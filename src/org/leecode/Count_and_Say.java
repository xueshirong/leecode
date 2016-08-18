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
}
