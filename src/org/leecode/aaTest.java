package org.leecode;
//From Bloomburg 面经 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=272680&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public class aaTest {
	//coding的题很简单就是一个矩阵
	//1 1 1
	//1 1 1
	//1 1 1
	//怎样in place把每个位置的元素变成所有右边和下边元素的和
	//9 6 3
	//6 4 2
	//3 2 1
	public static void main(String[] args){
        int[][] input = new int[][]{{1,1,1}, {1,1,1}, {1,1,1}};
        System.out.println("The input is");
        print(input);
        System.out.println();
        int[][] res = find(input);
        print(res);
    }
    private static void print(int[][] res){
        for (int i =0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j] + "");
            }
            System.out.println();
        }
    }
    //DP: nums[i][j] = nums[i][j] + nums[i + 1][j] + nums[i][j + 1] - nums[i + 1][j + 1]
    private static int[][] find(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        for (int i = m - 1; i > -1; i--){
            for (int j = n - 1; j > -1; j--){
                int sum = nums[i][j];
                if (i + 1 < m)
                    sum += nums[i + 1][j];
                if (j + 1 < n)
                    sum += nums[i][j + 1];
                if (i + 1 < m && j + 1 < n)
                    sum -= nums[i + 1][j + 1];
                nums[i][j] = sum;               
            }
        }
        return nums;
    }
    //类似求矩形的面积
    private static int[][] find1(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        for (int i = m - 1; i > -1; i--){
            for (int j = n - 1; j > -1; j--){
                nums[i][j] = (m - i)*(n -j);
            }
        }
        return nums;
    }
}
