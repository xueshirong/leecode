package Yelp;

public class String_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = compress("aaabbca");
		System.out.println(res);
		res = compress("aaaa");
		System.out.println(res);

	}
	
	public static String compress(String input) {
		if (input == null || input.length() == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			while (i < input.length() && input.charAt(i) == c) {
				i++;
				count++;
			}
			if (count > 1) {
				result.append(c).append(String.valueOf(count));
			} else {
				result.append(c);
			}
			i--;
			count = 0;
		}
		return new String(result);
	}
	
	public static String compress2(String str){
        if (str == null || str.equals(""))
            return str;
        char pre = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) != str.charAt(i - 1)){
                sb.append(str.charAt(i - 1));
                sb.append(count);
                count = 1;
                pre = str.charAt(i);
            }else{
                count++;
                continue;
            }
        }
        sb.append(pre);
        sb.append(count);
        
        if (sb.toString().length() >= str.length())
            return str;
        return sb.toString();
    }

}
