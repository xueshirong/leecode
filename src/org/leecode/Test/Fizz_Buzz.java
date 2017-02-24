package org.leecode.Test;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
	public List<String> fizzBuzz1(int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++){
            if (i % 15 == 0)
                res.add("FizzBuzz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else
                res.add(String.valueOf(i));
        }
        return res;
    }
    //follow up without using '%'
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        int Buzz = 0, Fizz = 0;
        for (int i = 1; i <= n; i++){
            Buzz++;
            Fizz++;
            if (Buzz == 5 && Fizz == 3){
                res.add("FizzBuzz");
                Buzz = 0;
                Fizz = 0;
            }else if (Fizz == 3){
                res.add("Fizz");
                Fizz = 0;
            }else if (Buzz == 5){
                res.add("Buzz");
                Buzz = 0;
            }else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
