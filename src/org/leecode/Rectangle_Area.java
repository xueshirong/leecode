package org.leecode;

public class Rectangle_Area {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = 0;
        int abcd = (D - B) * (C - A);
        int efgh = (H - F) * (G - E);
        
        int left = Math.max(A,E);
        int right = Math.min(G,C);
        int top = Math.min(H,D);
        int bottom = Math.max(B,F);
        
        if (left < right && top > bottom){
            res = abcd + efgh - (right - left) * ( top - bottom);
        }else{
            res = abcd + efgh;
        }
        return res;
    }
}
