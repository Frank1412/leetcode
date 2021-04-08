package com.bonc.leetcode_solution;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-10 17:24
 */
public class Q4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 时间复杂度O(m+n) 很复杂，未实现
//        int len = nums1.length + nums2.length;
//        if (nums1.length==0){
//            if (nums2.length%2==0) return (nums2[len/2-1] + nums2[len/2])/2.0;
//            else return nums2[len/2];
//        }
//        if (nums2.length == 0){
//            if (nums1.length%2==0) return (nums1[len/2-1] + nums1[len/2])/2.0;
//            else return nums1[len/2];
//        }
//        int i = 0, j = 0;
//        boolean bigger1 = true;
//        while (i < nums1.length && j < nums2.length && i + j + 1 < len / 2) {
//            if (nums1[i] < nums2[j]) {
//                i++;
//                bigger1 = false;
//            } else {
//                j++;
//                bigger1 = true;
//            }
//        }
//        if (i+j+1 == len/2){
//            if (len%2==0){
//                if (bigger1){
//                    System.out.println(i);
//                    if (j+1<nums2.length){
//                        if (nums1[i]>nums2[j+1]) return (nums2[j]+nums2[j+1])/2.0;
//                        else return (nums1[i] + nums2[j])/2.0;
//                    }else{
//                        return (nums1[i] + nums2[j])/2.0;
//                    }
//                } else {
//                    if (i+1<nums1.length){
//                        if (nums2[j]>nums1[i+1]) return (nums1[i]+nums1[i+1])/2.0;
//                        else return (nums1[i] + nums2[j])/2.0;
//                    }else{
//                        return (nums1[i] + nums2[j])/2.0;
//                    }
//                }
//            }else{
//                if (bigger1){
//                    if (j+1<nums2.length){
//                        if (nums1[i]>nums2[j+1]) return nums2[j+1];
//                        else return Math.max(nums1[i], nums2[j]);
//                    }else{
//                        return Math.max(nums1[i], nums2[j]);
//                    }
//                }else {
//                    if (i+1<nums1.length){
//                        if (nums2[j]>nums1[i+1]) return nums1[i+1];
//                        else return Math.max(nums1[i], nums2[j]);
//                    }else{
//                        return Math.max(nums1[i], nums2[j]);
//                    }
//                }
//            }
//        }
//        if (i==nums1.length){
//            if (len%2==1){
//                return nums2[len/2-nums1.length];
//            }else{
//                int target = len/2-nums1.length;
//                return (nums2[target-1] + nums2[target])/2.0;
//            }
//        }
//        if (j == nums2.length){
//            if (len%2==1){
//                return nums1[len/2-nums2.length];
//            }else{
//                int target = len/2-nums2.length;
//                return (nums1[target-1] + nums1[target])/2.0;
//            }
//        }
//        return 0.0;


        // 时间复杂度O(log(m+n))
        int m = nums1.length, n = nums2.length;

        double result = (getKthNumber(nums1, nums2, 0, 0, (m+n+1)/2) + getKthNumber(nums1, nums2, 0, 0, (m+n+2)/2))/2.0;
        return result;
    }

    public static int getKthNumber(int []nums1, int []nums2, int start1, int start2, int k){
        System.out.println(start1);
        if (nums1.length-start1 > nums2.length-start2) return getKthNumber(nums2, nums1, start2, start1, k);
        if (start1>nums1.length-1) return nums2[start2+k-1];
        if (k==1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int m1 = nums1[Math.min(start1+k/2-1, nums1.length-1)], m2 = nums2[Math.min(nums2.length-1, start2 + k/2-1)], len1 = nums1.length, len2 = nums2.length;
        if (m1 > m2){
            return getKthNumber(nums1, nums2, start1, start2+k/2, k-(Math.min(nums2.length-1, start2 + k/2-1)-start2+1));
        }else{
            return getKthNumber(nums1, nums2, start1+k/2, start2, k-(Math.min(start1+k/2-1, nums1.length-1)-start1+1));
        }
    }

    public static void main(String[] args) {
        int []a1 = {1};
        int []a2 = {2,3,4,5,6};
        double result = findMedianSortedArrays(a1, a2);
        System.out.println(result);
    }
}
