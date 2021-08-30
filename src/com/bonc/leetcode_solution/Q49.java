package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-06 11:32
 * @description:
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        // O(n2)时间复杂度
//        List<List<String>> result = new ArrayList<>();
//        LinkedList<String> ans1 = new LinkedList<>();
//        HashMap<Integer, List<String>> hm = new HashMap<>();
//        ans1.add(strs[0]);
//        hm.put(0, ans1);
//        for (int i=1;i<strs.length;i++){
//            int j;
//            for (j=0;j<i;j++){
//                if (isAnagram(strs[i], strs[j])){
//                    hm.get(j).add(strs[i]);
//                    break;
//                }
//            }
//            if (j==i){
//                LinkedList<String> tmp = new LinkedList<>();
//                tmp.add(strs[i]);
//                hm.put(i, tmp);
//            }
//        }
//        for (List<String> str: hm.values()){
//            result.add(str);
//        }
//        return result;

        Map<String, List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            char[] count = new char[26];
            for (int j=0;j<strs[i].length();j++){
                count[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<26;j++){
                if (count[j]!=0){
                    sb.append('a'+j);
                    sb.append(count[j]);
                }
            }

            List<String> lst = map.getOrDefault(sb.toString(), new ArrayList<>());
            lst.add(strs[i]);
            map.put(sb.toString(), lst);
        }
        return new ArrayList<>(map.values());

    }

    private boolean isAnagram(String s1, String s2){
        if (s1.length()!=s2.length()) return false;
        char[] count1 = new char[26];
        char[] count2 = new char[26];
        for (int i = 0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }

        return Arrays.equals(count1, count2);
    }
}
