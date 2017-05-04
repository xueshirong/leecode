package org.leecode.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class tiny_url {
	Map<String,Integer> url2id = new HashMap<String,Integer>();
	Map<Integer, String> id2url = new HashMap<Integer, String>();
	String dic = "0123456789abcdefghigklmnopgrstuvwxyzABCDEFGHIGKLMNOPKRSTUVWXYZ";
	int count = 0;
	//long urs to short urs
	public String longToShort(String url){
		String res = "";
		if (url2id.containsKey(url)){
			return "http://tiny.url/" + id2Short(url2id.get(url));
		}
		count++;
		url2id.put(url, count);
		id2url.put(count, url);
		res = "http://tiny.url/" + id2Short(count);		
		return res;
	}
	
	//short url to long url
	public String shortToLong(String url){
		String sh_url = url.substring("http://tiny.url/".length());
		int id = short2id(sh_url);
		
		return id2url.get(id);		
	}
	
	private int short2id(String sh_url) {
		int id = 0;
		for (int i = 0; i < sh_url.length(); i++){
			id = id * 62 + toBase62(sh_url.charAt(i));
		}
		return id;
	}

	private int toBase62(char c) {
		if (c >= '0' && c <= '9'){
			return c - '0';
		}
		if (c >= 'a' && c <= 'z'){
			return c - 'a' + 10;
		}
		if (c >= 'A' && c <= 'Z'){
			return c - 'A' + 36;
		}		
		return 0;
	}

	private String id2Short(int id) {
		String res = "";
		while(id > 0){
			res = dic.charAt(id%62) + res;
			id = id/62;
		}
		while(res.length() < 6){
			res = "0" + res;
		}
		return res;
	}
}
