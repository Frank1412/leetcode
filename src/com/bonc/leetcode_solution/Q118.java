package com.bonc.leetcode_solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-22 14:08
 * @description:
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 */
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i=0;i<numRows;i++){
            List<Integer> cur = new LinkedList<>();
            cur.add(1);
            if (i == 0) {
                res.add(cur);
                continue;
            }
            List<Integer> last = res.get(i-1);
            for (int j=0;j<last.size()-1;j++){
                cur.add(last.get(j)+last.get(j+1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
