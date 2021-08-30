package com.bonc.leetcode_solution;

import java.util.Arrays;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-29 16:58
 * @description:
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *     Each child must have at least one candy.
 *     Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 */
public class Q135 {
    public int candy(int[] ratings) {

        // 2次扫描
//        int len = ratings.length;
//        int[] left=new int[len], right=new int[len];
//        Arrays.fill(left, 1);
//        Arrays.fill(right, 1);
//        for (int i=1;i<len;i++){
//            left[i] = ratings[i]>ratings[i-1]?left[i-1]+1:1;
//            right[len-i-1] = ratings[len-i-1]>ratings[len-i]?right[len-i]+1:1;
//        }
//
//        int sum = 0;
//        for (int i=0;i<len;i++){
//            sum += Math.max(right[i], left[i]);
//        }
//        return sum;

        // 1次扫描  递减区间等差数列 考虑相等的情况
        int len = ratings.length, desc_num=0, pre=1, res=1;
        for (int i=1;i<len;i++){
            if (ratings[i]>ratings[i-1]){
                if (desc_num>0){
                    res += (1+desc_num)*desc_num/2;
                    if (desc_num >= pre) {
                        res += desc_num-pre+1;
                    }
                    pre = 1;
                    desc_num=0;
                }
                pre = pre+1;
                res += pre;
            }
            if (ratings[i]==ratings[i-1]){
                if (desc_num>0){
                    res += (1+desc_num)*desc_num/2;
                    if (desc_num >= pre) {
                        res += desc_num-pre+1;
                    }
                    desc_num=0;
                }
                pre = 1;
                res+=pre;
            }
            if (ratings[i]<ratings[i-1]){
                desc_num += 1;
            }
        }
        if (desc_num>0){
            res += (1+desc_num)*desc_num/2;
            if (desc_num >= pre) {
                res += desc_num-pre+1;
            }
        }
        return res;
    }
}
