package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-04-08 21:26
 * @description:
 */
public class Q6 {
    public String convert(String s, int numRows) {
        if(2>numRows){
            return s;
        }
        List<StringBuilder> str_list = new ArrayList<>();
        for(int j=0;j<numRows;j++) str_list.add(new StringBuilder());
        int i=0;
        boolean flag=true;

        for(char c: s.toCharArray()){
            if(flag&&i<numRows){
                str_list.get(i).append(c);
                i++;
            }else if(flag&&i==numRows){
                i-=2;
                str_list.get(i).append(c);
                i--;
                flag=!flag;
            }else if(!flag&&i>-1){
                str_list.get(i).append(c);
                i--;
            }else{
                i+=2;
                str_list.get(i).append(c);
                i++;
                flag = !flag;
            }
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder str: str_list){
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q6().convert("PAYPALISHIRING", 4));
    }
}
