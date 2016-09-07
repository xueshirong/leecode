package org.leecode;

public class Valid_Number {
	//not apply for the scientific notation
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.indexOf("-") == 0 || s.indexOf("+") == 0)//remove postive/negative sign at the beginning
            s = s.substring(1, s.length());
        if (s.indexOf(".") == 0){//remove the dot sign at the beginning eg: .3
            s = s.replaceFirst(".", "");
        }
        else if (s.indexOf(".") == 1){//3.22
        	s = s.substring(0, 1) + s.substring(1, s.length() - 1);
        }
        int last = s.length() - 1;
        if (last > 0 && s.charAt(last) == '.') {//remove the dot at the end eg: 3.
            s = s.substring(0, last - 1);
        }
        if (s.equals(""))
            return false;
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}
