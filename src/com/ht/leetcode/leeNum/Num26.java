package com.ht.leetcode.leeNum;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Num26 {


    public static int removeDuplicates(int[] nums) {

        int i = 1;
        int j = 0;
        for (; i < nums.length; i++) {
            for (; j < nums.length; j++) {
                if (j == nums.length - 1) {
                    return i;
                }
                if (nums[j] != nums[j + 1]) {

                    nums[i] = nums[j + 1];
                    j++;
                    break;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

}
