package com.ht.leetcode.array;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Test001 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2)return null;
        int arr [] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;


    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,4,5,7,8,3,6,9,0};
        Test001 t = new Test001();
        int[] ints = t.twoSum(arr, 15);
        System.out.println(ints[0]+":"+ints[1]);
    }

}
