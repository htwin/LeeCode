package com.ht.leetcode.leeNum;

public class Num35 {

    public static int searchInsert(int[] nums, int target) {

        //比第一个小
        if (target <= nums[0]) return 0;

        //比最后一个大
        if (target > nums[nums.length - 1]) return nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (target<=nums[i]) return i;


        }
        return nums.length;

    }


    public static void main(String[] args) {
        int nums [] = new int[]{1};
        System.out.println(searchInsert(nums,0));
    }

}
