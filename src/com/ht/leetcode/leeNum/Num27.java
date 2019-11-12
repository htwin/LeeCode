package com.ht.leetcode.leeNum;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Num27 {

    public static int removeElement(int[] nums, int val) {


        int i = 0;//i 就是移除后数组的新长度
        for(;i<nums.length;i++){

            //如果发现该元素等于指定的值，则从剩下的元素中找到相异的值，然后交换
            if(nums[i]==val){
                int j = i+1;

                while(true){

                    //找到最后都没有找到不等于val的值，说明已经排除完毕，返回i
                    if(j==nums.length){
                        return i;
                    }

                    //找到不等于val的值，与i位置交换，然后继续遍历i
                    if(nums[j]!=val){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    j++;

                }

            }


        }


        return i;
    }

    public static void main(String[] args) {
        int nums [] = new int[]{3};
        System.out.println(removeElement(nums,2));
    }

}
