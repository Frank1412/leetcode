package com.bonc.leetcode_solution;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while (j<nums.length){
            if (nums[j]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {

    }
}
