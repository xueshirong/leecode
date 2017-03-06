package org.leecode;

public class Convert_a_Number_to_Hexadecimal {
	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	public String toHex1(int num) {
	    if(num == 0) return "0";
	    String result = "";
	    while(num != 0){
	        result = map[(num & 0xF)] + result; 
	        num = (num >>> 4);
	    }
	    return result;
	}
	//一个整型的数，在计算机内部是怎么存储的呢？
    //很明显是已二进制的形式存储的，那么不管我们输入的是正数还是负数，其实计算机内部已经有了完整的存储，
    //那么其实不需要我们自己再去计算反码补码，我们只需要对其进行2进制转换成16进制就可以了。
	public String toHex(int num) {
		String[] map = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String res = "";
        while (num != 0){
            res = map[(num & 0xf)] + res;
            num = (num >>> 4);
        }
        return res;
    }
}
