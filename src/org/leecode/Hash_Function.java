package org.leecode;

public class Hash_Function {
	/**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {//cause overflow
        // write your code here
        int res = 0;
        int sum = 0;
        for(int i = 0; i < key.length; i++){
            sum += key[i] * Math.pow(33, key.length - 1 - i);
        }
        
        res = sum % HASH_SIZE;
        return res;
    }
    
    public int hashCode2(char[] key,int HASH_SIZE) {
        long res = 0;
        for(int i = 0; i < key.length;i++) {
            res = (key[i] + res * 33);
            res = res % HASH_SIZE;
        }

	return (int)res;
    }
}
