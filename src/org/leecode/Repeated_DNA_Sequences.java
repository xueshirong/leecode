package org.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Repeated_DNA_Sequences {
	//最简单的做法，我们可以把位移一位后每个子串都存入HashSet中，如果HashSet中已经有这个子串，而且是第一次重复，则加入结果中。
    //如果已经遇到多次，则不加入结果中。如果HashSet没有这个子串，则把这个子串加入另一个HashSet中。
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        Set<String> set = new HashSet<String>();
        Set<String> resset = new HashSet<String>();
        for (int i = 10; i <= s.length(); i++){
            String sub = s.substring(i - 10, i);
            if (!set.add(sub)){
                //res.add(sub);
                resset.add(sub);//key point to remove duplicated sub. "aaaaaaaaaaa"
            }
        }
        res = new ArrayList(resset);//change hashset to arraylist
        return res;
    }
    
    //from jiu zhang: encoding
    public int encode(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sum = sum * 4;
            } else if (s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if (s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<Integer> hash = new HashSet<Integer>();
        HashSet<String> dna = new HashSet<String>();
        for (int i = 9; i < s.length(); i++) {
            String subString = s.substring(i - 9, i + 1);
            int encoded = encode(subString);
            if (hash.contains(encoded)) {
                dna.add(subString);
            } else {
                hash.add(encoded);
            }
        }
        List<String> result = new ArrayList<String>();
        for (String d: dna) {
            result.add(d);
        }
        return result;
    }
}
