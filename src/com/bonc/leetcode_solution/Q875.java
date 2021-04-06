package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-04-06 20:05
 * @description:
 */
public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r=0;
        for(int b: piles){
            r = Math.max(r, b);
        }
        while(l<r){
            int mid = l + (r-l)/2;
            if(canEatAll(piles, mid, h)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean canEatAll(int []piles, int k, int h){
        int need = 0;
        for(int b: piles){
            need += Math.ceil(b*1.0/k);
        }
        return need <= h;
    }
}
