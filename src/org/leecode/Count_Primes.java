package org.leecode;

import java.util.Arrays;
/*
Description:
Count the number of prime numbers less than a non-negative number, n.
*/
public class Count_Primes {
	public int countPrimes(int n) {
        boolean[] prime = new boolean[n];// build a array to record whether it is prime
        int count = 0;
        Arrays.fill(prime, true);//initial all are prime first
        for (int i = 2; i < n; i++){//loop element less than n one by one
            if (prime[i]){
                count++;
                for(int j = 2; i * j < n; j++){//check the value which is j times greater than i, and set it false
                    prime[i*j] = false;
                }
            }
        }
        return count;
    }
}
