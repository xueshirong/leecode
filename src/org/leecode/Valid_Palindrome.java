package org.leecode;

public class Valid_Palindrome {
	public boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;
        s = s.toLowerCase();
        String newS = "";
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)){
                newS = newS + String.valueOf(c);
            }
        }
        for (int i = 0, j = newS.length() - 1; i < j; i++, j--){
            if (newS.charAt(i) != newS.charAt(j))
                return false;
        }
        return true;
    }
	
	public boolean isPalindrome2(String s) {
        if(s==null) return true;
        int i=0;
        int j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            if(!isValidChar(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValidChar(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isValidChar(char ch){
        if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9'))
            return true;
        else return false;
    }

    public boolean isPalindrome3(String s) {
    	if(s.equals(""))
            return true;
        s = s.toLowerCase();//Uppercase and lowercase shoule be considered
        int i = 0, j = s.length() - 1;
        while (i < j){
            char cl = s.charAt(i);
            char cr = s.charAt(j);
            if (!Character.isLetterOrDigit(cl))//isLetterOrDigit(), isDigit(), isLetter()
                i++;
            else if (!Character.isLetterOrDigit(cr))
                j--;
            else if (cl != cr)
	                return false;
	        else{
	            i++;
	            j--;
            }
        }
        return true;
    }
    
    public boolean isPalindrome4(String s) {
        if (s.trim() == "")
            return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while(i < j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!(Character.isDigit(ci) || Character.isLetter(ci))){
                i++;
                continue;
            }
            if (!(Character.isDigit(cj) || Character.isLetter(cj))){
                j--;
                continue;
            }
            if (ci != cj)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
