package org.leecode;

public class Detect_Capital {
	//用变量upper记录大写字母的个数。
    //如果upper== 0,说明全是小写；upper=word长度，说明全是大写；upper=1，只需要判断是否第一个字母为大写
    public boolean detectCapitalUse(String word) {
        boolean isFirstCap = false;
        int upper = 0;
        
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (i == 0 && Character.isUpperCase(c)){
                isFirstCap = true;
                upper++;
                continue;
            }
            if (Character.isUpperCase(c)){
                upper++;
            }
        }
        if(upper == word.length() || upper == 0 || (isFirstCap && upper == 1))
            return true;
        return false;
    }
    //solution 2
    public boolean detectCapitalUse1(String word) {
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
