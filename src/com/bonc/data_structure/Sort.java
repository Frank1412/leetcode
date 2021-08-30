package com.bonc.data_structure;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-29 12:51
 * @description:
 */
public class Sort {

    private void quickSort(int[] nums, int start, int end){
        if (start>=end) return ;

        int pivot = start, i=start, j=end;
        while (i < j) {
            while (i<j&&nums[j] >= nums[pivot]) {
                j--;
            }
            swap(nums, pivot, j--);
            while (i<j&&nums[i]<=nums[pivot]){
                i++;
            }
            swap(nums, i++, pivot);
        }
        quickSort(nums, start, pivot-1);
        quickSort(nums, pivot+1, end);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
