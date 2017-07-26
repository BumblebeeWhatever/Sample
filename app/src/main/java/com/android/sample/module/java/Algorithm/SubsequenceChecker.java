package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/19.
 * 判断String子类包含问题(medium)
 */

public class SubsequenceChecker {

    public static void main(String[] args) {
        System.out.println(checkSubsequence("", "abvdcc"));
    }

    /**
     * 判断subStr是被fullStr所包含(不需要连续，只要字符顺序符合即可)
     * @param subStr
     * @param fullStr
     * @return
     */
    public static boolean checkSubsequence(String subStr, String fullStr) {
        if (subStr == null || fullStr == null) {
            return false;
        }

        char[] subChar = subStr.toCharArray();
        char[] fullChar = fullStr.toCharArray();

        int subEnd = subChar.length - 1;
        int fullCharEnd = fullChar.length - 1;

        if (subEnd == -1) {
            return true;
        }

        if (subEnd > fullCharEnd) {
            return false;
        }

        int subStart = 0;
        int fullCharStart = 0;

        boolean startFound = false;//是否一轮找到
        boolean endFound = false;

        for (; subStart <= subEnd; ) {
            for (; fullCharStart <= fullCharEnd; ) {
                if (fullChar[fullCharStart] == subChar[subStart]) {
                    startFound = true;
                }
                if (fullChar[fullCharEnd] == subChar[subEnd]) {
                    endFound = true;
                }
//                System.out.println("start:" + startFound + ",subStart:" + subStart + ",fullCharStart:" + fullCharStart);
//                System.out.println("end:" + endFound + ",subEnd:" + subEnd + ",fullCharEnd:" + fullCharEnd);
//                System.out.println();

                if (startFound && endFound) {
                    if (subStart >= subEnd - 1) {
                        return true;
                    }
                    if (fullCharStart == fullCharEnd - 1) {
                        return false;
                    }
                    if (subStart + 2 == subEnd) {
                        ++subStart;
                        startFound = false;
                        ++fullCharStart;
                    } else {
                        ++subStart;
                        --subEnd;
                        startFound = false;
                        endFound = false;
                        ++fullCharStart;
                        --fullCharEnd;
                    }
                } else if (startFound) {
                    if (fullCharStart >= fullCharEnd - 1) {
                        return false;
                    }
                    if (subStart > subEnd - 1) {
                        return true;
                    }
                    if (subStart == subEnd - 1) {
                        --fullCharEnd;
                    } else {
                        ++subStart;
                        startFound = false;
                        ++fullCharStart;
                        --fullCharEnd;
                    }
                } else if (endFound) {
                    if (fullCharStart >= fullCharEnd - 1) {
                        return false;
                    }
                    if (subStart > subEnd - 1) {
                        return true;
                    }
                    if (subStart == subEnd - 1) {
                        ++fullCharStart;
                    } else {
                        --subEnd;
                        endFound = false;
                        ++fullCharStart;
                        --fullCharEnd;
                    }
                } else {
                    if (fullCharStart >= fullCharEnd - 2) {
                        return false;
                    }
                    ++fullCharStart;
                    --fullCharEnd;
                }
            }
        }
        return false;
    }

}
