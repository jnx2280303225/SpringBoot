package com.jnx.springboot.leetcode;

import java.util.Arrays;

/**
 * [16]最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * Related Topics 数组 双指针
 *
 * @author 蒋楠鑫
 * @date 2020/6/24
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    /**
     * 双指针遍历
     *
     * @param nums   数组
     * @param target 目标值
     * @return 最接近的三个数的和
     */
    public static int threeSumClosest(int[] nums, int target) {
        // 先按照升序排序
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            // 双指针遍历，前指针从i+1开始，后指针从nums.length-1开始
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                // 如果距离目标值更近就替换结果
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
                // 由于是升序排序，和大于结果值要移动后指针，和小于结果值要移动前指针
                if (sum > target) {
                    end--;
                }
                if (sum < target) {
                    start++;
                }
                if (sum == target) {
                    return sum;
                }
            }
        }
        return result;
    }
}
