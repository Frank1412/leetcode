package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-12 20:19
 * @description: 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        if (intervals.length==0){
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }
        boolean placed = false;
        int left = newInterval[0], right = newInterval[1];
        for (int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            if (interval[0]>right){
                if (!placed){
                    result.add(new int[]{left, right});
                    placed = true;
                }
                result.add(interval);
            }else if (interval[1]<left){
                result.add(interval);
                if (i==intervals.length-1){
                    result.add(new int[]{left, right});
                }
            }else{
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
                if (i==intervals.length-1){
                    result.add(new int[]{left, right});
                }
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
