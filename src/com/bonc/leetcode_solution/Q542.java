package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-02-27 17:06
 * @description:
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent celwls is 1.
 *
 */
public class Q542 {
    private int[][] direction = {{1,0}, {0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        int d1=matrix.length, d2 = matrix[0].length;
        int[][] res = new int[d1][d2];
        Deque<int[]> queue = new LinkedList<>();
        Boolean[][] visited = new Boolean[d1][d2];
        for (int i=0;i<d1;i++){
            for (int j=0;j<d2;j++){
                if (matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
                visited[i][j] = false;
            }
        }
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int[] cur = queue.poll();
                int p=cur[0], q=cur[1];
                if (matrix[p][q]==1){
                    res[p][q] = level;
                }
                for (int[] a: direction){
                    int x=p+a[0], y=q+a[1];
                    System.out.println(x + "  "+y);
                    if ((x>=0)&&(x<d1)&&(y>=0)&&(y<d2)&&!visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(1,2);
        hm.put(1,3);
        System.out.println(hm);
    }
}
