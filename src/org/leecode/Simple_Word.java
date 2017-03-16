package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Simple_Word {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> dict = new ArrayList<String>();
        /*dict.add("sales");
        dict.add("person");
        dict.add("salesperson");
        dict.add("whatsoever");
        dict.add("what");
        dict.add("so");
        dict.add("ever");
        dict.add("per");
        dict.add("son");*/
       
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            String s = scan.nextLine();
            dict.add(s);
        }
        List<String> res = simpleWord(dict);
        System.out.print(Arrays.toString(res.toArray()));
    }
	static List<String> simpleWord(ArrayList<String> list){
        List<String> res = new ArrayList<String>();        
        for (int i = 0; i< list.size(); i++){
            String word = list.get(i);
            list.remove(i);
            if (helper(list, word)){
                res.add(word);
            }
            list.add(i, word);
        }
        return res;
    }
	static boolean helper(List<String> dict, String word){
        int n = word.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if(f[j] && dict.contains(word.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return !f[n];
    }
}
