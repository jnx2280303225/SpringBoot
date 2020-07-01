package com.jnx.springboot.javase.leetcode;

import java.util.Random;

/**
 * [215]数组中的第k个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * Related Topics 堆 分治算法
 *
 * @author 蒋楠鑫
 * @date 2020/6/29
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(findKthLargest2(nums, 2));
    }

    /**
     * 解法一：基于快速排序的分治思想
     *
     * @param nums 目标数组
     * @param k    第k个最大的元素
     * @return 元素的值
     */
    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        // 按照升序排序后，第k大的元素的索引就是length-k
        int target = length - k;
        Random random = new Random();
        while (true) {
            // 在区间[left,right]执行分治操作
            if (right > left) {
                // 随机选取一个切入点，将左边元素和随机切点交换，避免倒序数组的情况耗时严重，提高性能
                int randonIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randonIndex);
            }
            // 从left开始，如果小于pivot交换元素位置，保证pivot左边的元素都不大于pivot
            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    // 小于基准数的向左移动
                    j++;
                    swap(nums, j, i);
                }
            }
            // 将基准值放到最后一个最小的位置，并记录这个位置的索引
            swap(nums, left, j);
            if (j < target) {
                left = j + 1;
            }
            if (j > target) {
                right = j - 1;
            }
            if (j == target) {
                return nums[j];
            }
        }
    }

    /**
     * 交换数组中两个索引对应的元素的位置
     *
     * @param arr         数组
     * @param firstIndex  第一个索引
     * @param secondIndex 第二个索引
     */
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    /**
     * 解法二：基于堆排序的方法，构造最大堆，删除k-1个元素
     *
     * @param nums 目标数组
     * @param k    第k个最大的元素
     * @return 元素的值
     */
    public static int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        bulidMaxHeap(nums);
        // 第k大的元素的索引就是length-k
        int target = length - k;
        // 每次都将最大的数字最大的数字移除并调整最大堆，知道找到第k大的
        for (int i = nums.length - 1; i > target; i--) {
            swap(nums, 0, i);
            length--;
            adjustHeap(nums, 0, length);
        }
        return nums[0];
    }

    /**
     * 构建最大堆
     *
     * @param arr 数组
     */
    private static void bulidMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    /**
     * 调整最大堆
     *
     * @param arr    数组
     * @param index  当前非叶子节点的索引
     * @param length 数组长度
     */
    private static void adjustHeap(int[] arr, int index, int length) {
        // 先取出当前索引的元素
        int temp = arr[index];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        // 将temp值放到最终的位置
        arr[index] = temp;
    }
}
