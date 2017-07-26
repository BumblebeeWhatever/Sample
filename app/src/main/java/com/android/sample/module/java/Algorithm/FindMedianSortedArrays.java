package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/21.
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums2 = new int[]{3, 4};
        int[] nums1 = new int[]{1, 2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        int totalLength;//总长度
        int mid1;//中点1,起点为1
        boolean isOdd = false;//是否总长度为奇数

        if ((nums1 == null || nums1.length == 0)) {
            totalLength = nums2.length;
            isOdd = totalLength % 2 == 1;
            mid1 = isOdd ? (totalLength + 1) / 2 : totalLength / 2;
            return isOdd ? nums2[mid1 - 1] : (nums2[mid1 - 1] + nums2[mid1]) / 2f;
        } else if ((nums2 == null || nums2.length == 0)) {
            totalLength = nums1.length;
            isOdd = totalLength % 2 == 1;
            mid1 = isOdd ? (totalLength + 1) / 2 : totalLength / 2;
            return isOdd ? nums1[mid1 - 1] : (nums1[mid1 - 1] + nums1[mid1]) / 2f;
        }

        totalLength = nums1.length + nums2.length;
        isOdd = totalLength % 2 == 1;
        mid1 = isOdd ? (totalLength + 1) / 2 : totalLength / 2;
        int[] array = new int[totalLength];
        for (int i = 0, num1Index = 0, num2Index = 0; i < (isOdd ? mid1 : mid1 + 1); i++) {
            if (num1Index == nums1.length) {
                array[i] = nums2[num2Index];
                ++num2Index;
            } else if (num2Index == nums2.length || nums1[num1Index] <= nums2[num2Index]) {
                array[i] = nums1[num1Index];
                ++num1Index;
            } else if (nums2[num2Index] < nums1[num1Index]) {
                array[i] = nums2[num2Index];
                ++num2Index;
            }
        }
        return isOdd ? array[mid1 - 1] : (array[mid1 - 1] + array[mid1]) / 2f;
    }

}
