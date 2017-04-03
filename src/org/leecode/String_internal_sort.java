package org.leecode;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
public class String_internal_sort {
	////input: "F5DE24" "Db!32,1Ca". output: "D2EF35" "CD!12,3ab"
	//大致上就是input String 然後return String, 原本是數字的位置放數字, 原本是字母的位置放字母, 原本是其他符號的位置放其他符號
	//但數字和字母必須是sort過 由小到大放 其他符號則不用
	public static void main(String[] args){
		String res = sorts("Db!3b2,1Ca");
        System.out.print(res);
    }
	private static String sorts(String s){
        if (s == null || s == "")
            return s;
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            chars[c] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){
                for (int j = 0; j < 10; j++){
                    if (chars[j + '0'] > 0){
                        sb.append((char)(j + '0'));
                        chars[j + '0'] -= 1;
                        break;
                    }
                }
            }else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                boolean isfind = false;
                for (int j = 0; j < 26; j++){
                    if (chars[j + 'A'] > 0){
                        sb.append((char)(j + 'A'));
                        chars[j + 'A'] -= 1;
                        isfind = true;
                        break;
                    }
                }
                if (isfind) 
                    continue;
                for (int j = 0; j < 26; j++){
                    if (chars[j + 'a'] > 0){
                        sb.append((char)(j + 'a'));
                        chars[j + 'a'] -= 1;
                        break;
                    }
                }
            }else if (c >= 'a' && c <= 'z'){
                
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }	
}
