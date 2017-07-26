package com.android.sample.module.java.Algorithm;

/**
 * Created by hexiaolei on 2017/7/21.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (28 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 23 -> 1 -> 8
 * <p>
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode resultList = null;

        ListNode listNode = null;
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        int carry_bit = 0;//进位

        while (l1Next != null) {
            int sumVal = l1Next.val + carry_bit;
            if (l2Next != null) {
                sumVal += l2Next.val;
                l2Next = l2Next.next;
            }
            carry_bit = sumVal >= 10 ? 1 : 0;
            sumVal = sumVal - carry_bit * 10;

            if (listNode == null) {
                listNode = new ListNode(sumVal);
                resultList = listNode;
            } else {
                listNode.next = new ListNode(sumVal);
                listNode = listNode.next;
            }
            l1Next = l1Next.next;
        }

        while (carry_bit > 0) {
            int sumVal = carry_bit;
            if (l2Next != null) {
                sumVal += l2Next.val;
                l2Next = l2Next.next;
            }

            carry_bit = sumVal >= 10 ? 1 : 0;
            sumVal = sumVal - carry_bit * 10;

            listNode.next = new ListNode(sumVal);
            listNode = listNode.next;
        }

        while (l2Next != null) {
            listNode.next = new ListNode(l2Next.val);
            listNode = listNode.next;
            l2Next = l2Next.next;
        }

        return resultList;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
