package com.jnx.springboot.leetcode;

/**
 * [209]长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回0。
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * Related Topics 数组 双指针 二分查找
 *
 * @author 蒋楠鑫
 * @date 2020/6/28
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    /**
     * 双指针遍历
     *
     * @param s    给定的正整数
     * @param nums 数组
     * @return 和大于等于给定正整数的长度最小的连续子数组
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子数组的开始索引和截止索引
        int start = 0;
        int end = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                // 满足条件后缩小子数组的长度，将起始索引对应的值减去，再看和是否满足条件
                minSize = Math.min(minSize, end - start);
                sum -= nums[start++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
