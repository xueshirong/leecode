package org.leecode;

public class Detect_Capital {
	public boolean detectCapitalUse1(String word) {
        boolean isFirstCap = false;
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (i == 0 && Character.isUpperCase(c)){
                isFirstCap = true;
                upper++;
                continue;
            }
            if (Character.isUpperCase(c)){
                upper++;
            }else{
                lower++;
            }
        }
        if(upper == word.length() || lower == word.length() || (isFirstCap && lower == word.length() - 1))
            return true;
        return false;
    }
    //solution 2
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word))//判断全部是大写
            return true;
        if (word.toLowerCase().equals(word))//判断全部是小写
            return true;
            
        String tmp = word.substring(1, word.length());//判断除第一个字符外，其他全是小写
        if (tmp.toLowerCase().equals(tmp))
            return true;
            
        return false;
    }
}
