package com.jnx.springboot.javase.leetcode;

/**
 * [125]验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * Related Topics 双指针 字符串
 *
 * @author 蒋楠鑫
 * @date 2020/6/19
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("otto"));
    }

    /**
     * 双指针遍历
     *
     * @param s 给定的字符串
     * @return 是否为回文串
     */
    public static boolean isPalindrome(String s) {
        // 非空判断
        if (s == null || s.isEmpty()) {
            return true;
        }
        // 遍历字符串，双向查找
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                ++left;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                --right;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
