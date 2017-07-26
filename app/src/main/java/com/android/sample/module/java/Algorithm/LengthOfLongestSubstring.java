package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/21.
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    private static int maxLength = 0;
    private static int count = 0;
    private static int base = 0;

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        int[] array;
        int maxValue = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            int num = s.charAt(i);
            if (num > maxValue) {
                if (num == 128) {
                    maxValue = 128;
                    base = 0;
                    break;
                }
                maxValue = num;
            } else if (num < base) {
                base = num;
            }
        }

        array = new int[maxValue - base];

        int m;
        for (i = 0; i < s.length(); i++) {
            for (m = i; m < s.length(); m++) {
                if (contain(array, s.charAt(m))) {
                    reset(array);
                    break;
                }
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;

    }

    private static void reset(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    private static boolean contain(int[] array, char letter) {
        int index = letter - base - 1;
        boolean result = array[index] != 0;
        if (!result) {
            ++count;
            array[index] += array[index];
        }
        return result;
    }

}
