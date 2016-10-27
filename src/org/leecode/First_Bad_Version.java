package org.leecode;

public class First_Bad_Version {
	public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end){
        	int mid = start + (end - start)/2; //this line is a tricky
            if (isBadVersion(mid)){
                end = mid;
                
            }else{
                start = mid + 1; //*
            }
        }
        return start;
    }
	
	boolean isBadVersion(int n){
		if (n >= 4)
			return true;
		return false;
	}
	//From Jiu Zhang
	public int firstBadVersion2(int n) {
        // write your code here
        int s = 1;
        int e = n;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (isBadVersion(mid))
                e = mid;
            else
                s = mid;
        }
        
        if (isBadVersion(s))
            return s;
        else if (isBadVersion(e))
            return e;
        else
            return 0;
    }
}
