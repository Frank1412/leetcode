package com.bonc.leetcode_solution;

import java.util.HashMap;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-03 14:00
 * @description:
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 */
public class Q36 {
    // 用hashmap记录每个num -> count
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> []rows = new HashMap[9];
        HashMap<Integer, Integer> []cols = new HashMap[9];
        HashMap<Integer, Integer> []sub = new HashMap[9];

        for (int i=0;i<9;i++){
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            sub[i] = new HashMap<>();
        }

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    int num = (int)board[i][j];
                    int k = i/3*3+j/3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0)+1);
                    if (rows[i].get(num)>1){
                        return false;
                    }
                    cols[j].put(num, cols[j].getOrDefault(num, 0)+1);
                    if (cols[j].get(num)>1){
                        return false;
                    }
                    sub[k].put(num, sub[k].getOrDefault(num, 0)+1);
                    if (sub[k].get(num)>1){
                        return false;
                    }

                }
            }
        }
        return true;

    }
}
