package org.leecode;

public class TinyURL {
	private static final String MAP_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
    private static final int base = MAP_STRING.length(); // 62;  
  
    public String generateShortURL(long num) {  
        if(num <= 0) return null;  
        StringBuilder sb = new StringBuilder();  
        while(num >0) {  
            sb.append(MAP_STRING.charAt((int)num%base));  
            num = num / base;  
        }  
        return sb.reverse().toString();//记得reverse过来，因为刚开始的是高位，append在前面，算完之后应该放到后面去，那样decode的时候，容易计算高位，顺序计算就好了。  
    }  
      
    public long getShortURLID(String shortURL){  
        long res = 0;  
        if(shortURL == null) return res;  
        for(int i=0; i<shortURL.length(); i++){  
            res = res*base + MAP_STRING.indexOf(shortURL.charAt(i));  
        }  
        return res;  
    }  
      
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        TinyURL p = new TinyURL();  
        System.out.println("123456789 shortURL is:" + p.generateShortURL(123456789));  
        System.out.println("iwaUH id is:" + p.getShortURLID("iwaUH"));  
    }  
}
