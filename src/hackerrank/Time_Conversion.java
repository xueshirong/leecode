package hackerrank;

import java.util.Scanner;

public class Time_Conversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String time = in.next();
        String[] nums = time.split(":");
        if (time.contains("AM") || time.contains("am")){
            if (nums[0].equals("12"))
                nums[0] = "00";
            nums[2] = nums[2].replace("AM", "");
            System.out.print(nums[0] + ":" + nums[1] + ":" + nums[2]);
        }else{
            int hh = Integer.parseInt(nums[0]);
            if (hh != 12)
                hh = hh + 12;            
            nums[0] = String.valueOf(hh);
            
            nums[2] = nums[2].replace("PM", "");
            System.out.print(nums[0] + ":" + nums[1] + ":" + nums[2]);
        }
    }
}
