package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/21.
 */

public class TwoSum {

    public static void main(String[] args) {

    }

    /**
     * 从数组中取两个值add为target，返回其位置,f.e:[1,4,5] target =9.then return [1,2]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return result(0, 0);
        }
        if (nums.length == 2) {
            return result(0, 1);
        }
        int startIndex = 0;
        int endIndex = startIndex + 1;
        for (; startIndex < nums.length - 2; ) {
            for (; endIndex < nums.length; endIndex++) {
                if (nums[startIndex] + nums[endIndex] == target) {
                    return result(startIndex, endIndex);
                }
            }
            ++startIndex;
            endIndex = startIndex + 1;
        }
        return result(nums.length - 2, nums.length - 1);
    }

    private int[] result(int a, int b) {
        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }

}
