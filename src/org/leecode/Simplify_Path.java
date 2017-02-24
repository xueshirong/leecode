package org.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Simplify_Path {
	//归下类的话，有四种字符串：
    //"/"：为目录分隔符，用来分隔两个目录。
    //"."：当前目录
    //".."：上层目录
    //其他字符串：目录名
    //简化的核心是要找出所有的目录，并且如果遇到".."，需要删除上一个目录。
    public String simplifyPath(String path) {
        if (path == null || path.equals(""))
            return path;
        String[] array = path.split("/");
        Queue<String> q = new LinkedList<String>();
        for (String s : array){
            if (s.equals(".") || s.equals("")){
                continue;
            }else if (s.equals("..")){
                if (q.size() > 0)
                    q.poll();
            }else{
                q.offer(s);
            }
        }
        String res = "";
        while (!q.isEmpty()){
            res += "/" + q.poll();
        }
        
        if (res.equals(""))
            res = "/";
        return res;
    }
}
