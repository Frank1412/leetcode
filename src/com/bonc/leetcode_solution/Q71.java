package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-14 0:20
 * @description: Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * <p>
 * Example 1:
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * <p>
 * Example 2:
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * <p>
 * Example 3:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * <p>
 * Example 4:
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 */
public class Q71 {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        System.out.println(str.length);
        Deque<String> queue = new LinkedList<>();

        for (int i = 1; i < str.length; i++) {
            String s = str[i];
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append("/");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new Q71().simplifyPath("/home/");
    }
}
