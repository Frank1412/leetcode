package com.bonc.leetcode_solution;

import java.util.HashMap;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-03 14:58
 * @description: 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Q37 {
    public void solveSudoku(char[][] board) {

        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] sub = new int[9][10];
        HashMap<Integer, int[]> indexBox = new HashMap<>();
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                indexBox.put(x++, new int[]{i, j});
                int k = i / 3 * 3 + j / 3;
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = 1;
                    col[j][num] = 1;
                    sub[k][num] = 1;
                }
            }
        }

        fillSudoku(row, col, sub, board, indexBox, 0);
    }

    private boolean fillSudoku(int[][] row, int[][] col, int[][] sub, char[][] board, HashMap<Integer, int[]> indexBox, int index) {
        if (index == indexBox.size()) {
            return true;
        }
        int[] point = indexBox.get(index);
        int i = point[0], j = point[1], k = i / 3 * 3 + j / 3;
        if (board[i][j] != '.') {
            return fillSudoku(row, col, sub, board, indexBox, index + 1);
        } else {
            for (int t = 1; t < 10; t++) {
                if (row[i][t] != 1 && col[j][t] != 1 && sub[k][t] != 1) {
                    row[i][t] = col[j][t] = sub[k][t] = 1;
                    board[i][j] = (char) (t + '0');
                    if (fillSudoku(row, col, sub, board, indexBox, index + 1)) {
                        return true;
                    }
                    row[i][t] = col[j][t] = sub[k][t] = 0;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
