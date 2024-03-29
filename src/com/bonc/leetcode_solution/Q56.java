package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-12 16:07
 * @description:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class Q56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2)->(a1[0]-a2[0]));

        List<int []> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            int end = result.get(result.size()-1)[1];
            if (end>=intervals[i][0]){
                result.get(result.size()-1)[1] = Math.max(end, intervals[i][1]);
            }else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
