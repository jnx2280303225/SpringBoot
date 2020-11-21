package com.jnx.springboot.leetcode;

import java.util.Stack;

/**
 * [67]二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * Related Topics 数学 字符串
 *
 * @author 蒋楠鑫
 * @date 2020/6/23
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
        System.out.println(addBinary2(a, b));
        System.out.println(addBinary3(a, b));
    }

    /**
     * 解法一：直接遍历进行运算，判断是否进位
     *
     * @param a 二进制数字
     * @param b 二进制数字
     * @return 计算结果
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 获取两个数字最大位数
        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            // 逆序取数，从最后一个索引开始取，先计算最低位，如果位数不足就用0表示
            if (i < a.length()) {
                carry += a.charAt(a.length() - 1 - i) - '0';
            } else {
                carry += 0;
            }
            if (i < b.length()) {
                carry += b.charAt(b.length() - 1 - i) - '0';
            } else {
                carry += 0;
            }
            // 逢2进1
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        // 如果有进位最高位补1
        if (carry > 0) {
            sb.append("1");
        }
        // 翻转，因为是从最后一个索引开始取得，所以数字是倒序的
        return sb.reverse().toString();
    }

    /**
     * 解法二：递归算法
     *
     * @param a 二进制数字
     * @param b 二进制数字
     * @return 计算结果
     */
    public static String addBinary2(String a, String b) {
        return addBinaryHelper(a, a.length() - 1, b, b.length() - 1, 0);
    }

    private static String addBinaryHelper(String a, int indexA, String b, int indexB, int carry) {
        if (indexA < 0 && indexB < 0 && carry == 0) {
            return "";
        }
        if (indexA >= 0) {
            carry += a.charAt(indexA--) - '0';
        }
        if (indexB >= 0) {
            carry += b.charAt(indexB--) - '0';
        }
        int digit = carry % 2;
        carry = carry / 2;
        String res = addBinaryHelper(a, indexA, b, indexB, carry);
        return res + digit;
    }

    /**
     * 解法三：利用【栈】数据结构
     *
     * @param a 二进制数字
     * @param b 二进制数字
     * @return 计算结果
     */
    public static String addBinary3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        // 从后往前运算
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            // 位数较小的数需要补0
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            } else {
                carry += 0;
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            } else {
                carry += 0;
            }
            // 逢2进1
            stack.push(carry % 2);
            carry /= 2;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
