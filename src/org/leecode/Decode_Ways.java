package org.leecode;

public class Decode_Ways {
	//A message containing letters from A-Z is being encoded to numbers using the following mapping:
	//'A' -> 1  'B' -> 2  ...  'Z' -> 26
	public int numDecodings(String s) {
        //corner case
        if (s == "" || s.length() == 0)
            return 0;
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        if (s.charAt(0) == '0')
            res[1] = 0;
        else
            res[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            if (s.charAt(i - 1) != '0')
                res[i] = res[i - 1];
            int twodigit = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twodigit > 9 && twodigit <= 26)
                res[i] += res[i - 2];
        }
        return res[s.length()];
    }
}
