package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
	public int romanToInt(String s) {
        int len = s.length();
        int pre = this.char2int(s.charAt(0));
        if (len == 1){
            return pre;
        }
        int res = pre;
        int cur = 0;
        for (int i = 1; i < len; i++){
            pre = this.char2int(s.charAt(i - 1));
            cur = this.char2int(s.charAt(i));
            if (cur <= pre){
                res = res + cur;
            }else{
                res = res - 2*pre +cur;//this line is the core part
            }
        }
        return res;
    }
	
	public int romanToInt2(String s) {
        int len = s.length();
        int pre = this.char2int(s.charAt(len - 1));
        if (len == 1){
            return pre;
        }
        int res = pre;
        int cur = 0;
        for (int i = len - 2; i > -1; i--){
            pre = this.char2int(s.charAt(i + 1));
            cur = this.char2int(s.charAt(i));
            if (cur < pre){// should be "<", not "<="
                res = res - cur;
            }else{
                res = res + cur;
            }
        }
        return res;
    }
    
    public int char2int(char c){
        int res = 0;
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }
    //from Jiu Zhang
    public int romanToInt3(String s) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);//1
        map.put('V', 5);//5
        map.put('X', 10);//10
        map.put('L', 50);//50
        map.put('C', 100);//100
        map.put('D', 500);//500
        map.put('M', 1000);//1000
        int res = map.get(s.charAt(s.length() - 1));
        if (s.length() == 1)
            return res;
        for(int i = s.length() -2; i > -1; i--){
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
                res += map.get(s.charAt(i));
            }else{
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }
}
