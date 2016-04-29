package org.leecode;

public class Compare_Version_Number {
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length; i++){
            if (i >= v2.length){
                if (Integer.valueOf(v1[i]) > 0){
                    return 1;
                }
                continue;
            }
            int temp2 = Integer.valueOf(v2[i]);
            int temp1 = Integer.valueOf(v1[i]);
            if (temp1 > temp2){
                return 1;
            }else if (temp1 < temp2){
                return -1;
            }
        }
        if (v1.length < v2.length){
            for (int j = v1.length; j < v2.length; j++){
                if (Integer.valueOf(v2[j]) > 0){
                    return -1;                }
            }
        }
        
        return 0;
    }
}
