package org.leecode;

public class Guess_Number_Higher_or_Lower {
	public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high){
            int mid = low + (high - low)/2;
            switch(guess(mid)){
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
}
