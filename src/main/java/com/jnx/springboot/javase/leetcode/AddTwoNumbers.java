package com.jnx.springboot.javase.leetcode;

/**
 * [2]两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * Related Topics 链表 数学
 *
 * @author 蒋楠鑫
 * @date 2020/6/19
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        // 342 + 465 = 807
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        // 打印结果
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(sb.reverse().toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 两个数字相加超过10就需要加一，默认能加0，由于是逆序因此需要进位的其实是下一个节点上的val
        ListNode sumListNode = new ListNode(0);
        ListNode nextListNode = sumListNode;
        // 依次取出两个链表每个节点的值并求和
        int firstValue;
        int secondValue;
        int sum;
        // 是否需要进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 如果未null就说明少一位，自然要赋值为0
            if (l1 != null) {
                firstValue = l1.val;
            } else {
                firstValue = 0;
            }
            if (l2 != null) {
                secondValue = l2.val;
            } else {
                secondValue = 0;
            }
            // 求和并判断是否需要进位
            sum = carry + firstValue + secondValue;
            carry = sum / 10;
            nextListNode.next = new ListNode(sum % 10);
            nextListNode = nextListNode.next;
            // 计算完当前节点就计算下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后一个计算完如果还需要进位，说明两数之和变成了n+1位数
        if (carry > 0) {
            nextListNode.next = new ListNode(carry);
        }
        return sumListNode.next;
    }

    static class ListNode {

        /**
         * 节点的数值
         */
        private int val;

        /**
         * 指向下一个节点的指针
         */
        private ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
