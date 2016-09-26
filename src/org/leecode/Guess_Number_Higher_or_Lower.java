package org.leecode;

public class Guess_Number_Higher_or_Lower {
	public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high){
            int mid = low + (high - low)/2;
            switch(guess(mid)){
            //switch(1){
                case 0:
                    return mid;
                case 1:
                    low = mid + 1;//remember plus 1
                    break;
                case -1:
                    high = mid - 1;//remember minus 1
                    break;
            }
        }
        return low;
    }
	public int guessNumber2(int n) {
		int low = 1;
        int high = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if (guess(mid) ==  0)
                return mid;
            else if (guess(mid) == -1)//mid > target
                high = mid;
            else//mid < target
                low = mid + 1;
        }
        return low;
    }
	
	private int guess(int n){
		if (n == 6)
			return 0;
		else if (n > 6)
			return 1;
		return -1;
	}
}
