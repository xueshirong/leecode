package org.leecode;

import java.util.Hashtable;

public class Bulls_and_Cows {
	public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Hashtable<Integer, Character> tableS = new Hashtable<Integer, Character>();
        //get bulls and put others into tableS
        for (int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g){
                bulls++;
                continue;
            }
            tableS.put(i, s);
        }        
        //get cows and remove cows value from tableS
        for (int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (g != s && tableS.containsValue(g)){
                cows++;
                tableS.values().remove(g);
                continue;
            }
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }
}
