package org.leecode;

import java.util.Hashtable;

public class Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
		Hashtable<String, String> table = new Hashtable<String, String>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length)
            return false;
        for (int i = 0; i < pattern.length(); i++){
            String pKey = String.valueOf(pattern.charAt(i));
            String value = strArray[i];
            if(table.containsKey(pKey)){// if key exist
                String pValue = table.get(pKey);
                if (!pValue.equals(value)){//if the key's value doesn't equal to current value
                    return false;
                }
            }else if (table.containsValue(value)){// if key doesn't exist and vaule exist in hashtable, then key and value are not one-to-one
                return false;
            }
            else{
                table.put(pKey, value);
            }
        }
        return true;
    }
}
