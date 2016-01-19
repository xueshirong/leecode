package org.leecode;

public class Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
        int number = 0;
        
        /*for (int i = 0; i < s.length(); i++){
            number = number * 26 + (s.charAt(i) - 'A' + 1);
        }*/
        
        number = 0;
        for (int i = s.length()-1; i >-1; i--){
            number = (int) (number + (s.charAt(i) - 'A' + 1) * Math.pow(26,s.length()-1 - i));
        }
        return number;
    }
}
