package com.ht.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Test004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<=0){
            int len = nums2.length;
            int mid = len/2;
            return len%2==0?(nums2[mid-1]+nums2[mid])/2.0:nums2[mid];
        }

        if(nums2.length<=0){
            int len = nums1.length;
            int mid = len/2;
            return len%2==0?(nums1[mid-1]+nums1[mid])/2.0:nums1[mid];
        }

        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length||j<nums2.length){
            if (i<nums1.length&&j<nums2.length&&nums1[i]<nums2[j]){
                list.add( nums1[i]);
                if(i<nums1.length)i++;
            }
            if(i<nums1.length&&j<nums2.length&&nums1[i]>=nums2[j]){
                list.add(nums2[j]);
                if(j<nums2.length) j++;
            }
            if(i>=nums1.length){
                while(j<nums2.length){
                    list.add(nums2[j]);
                    j++;
                }
                break;
            }
            if(j>=nums2.length){
                while(i<nums1.length) {
                    list.add(nums1[i]);
                    if (i < nums1.length) i++;
                }
                break;
            }


        }
        int len = list.size();
        int mid = len/2;
        return len%2==0?(list.get(mid-1)+list.get(mid))/2.0:list.get(mid);
    }

    public static void main(String[] args) {
        int arr1 [] = new int[]{1,2,3,4};
        int arr2 [] = new int[]{};
        System.out.print(findMedianSortedArrays(arr1,arr2));
       /*int i =2;
       int j =3;
       double x = (2+3)/2.0;
        System.out.println(x);*/
    }
}
