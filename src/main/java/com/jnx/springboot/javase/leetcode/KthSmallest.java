package com.jnx.springboot.javase.leetcode;

import java.util.Arrays;

/**
 * [378]有序矩阵中第k小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * Related Topics 堆 二分查找
 *
 * @author 蒋楠鑫
 * @date 2020/7/2
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 1));
        System.out.println(kthSmallest2(matrix, 1));
    }

    /**
     * 解法一：转换成一维数组直接排序
     *
     * @param matrix n x n的有序矩阵
     * @param k      第k小的元素
     * @return 第 k 小的元素的值
     */
    public static int kthSmallest(int[][] matrix, int k) {
        // 把矩阵平铺成数组并排序，然后再找第k小的元素
        int row = matrix.length;
        int column = matrix[0].length;
        int[] arr = new int[row * column];
        // 将元素全都加入一维数组
        int index = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                arr[index++] = anInt;
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }

    /**
     * 解法二：二分查找法
     *
     * @param matrix n x n的有序矩阵
     * @param k      第k小的元素
     * @return 第 k 小的元素的值
     */
    public static int kthSmallest2(int[][] matrix, int k) {
        // 矩阵的行数，行列均为升序，可以知道第一个元素为最小值，最后一个元素为最大值
        int length = matrix.length;
        int min = matrix[0][0];
        int max = matrix[length - 1][length - 1];
        // 进行二分查找
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            // 判断目标值是否在mid左边
            if (check(matrix, mid, k, length)) {
                // 目标值<=mid，以mid为最大值继续二分查找
                max = mid;
            } else {
                // 目标值>mid，以mid+1为最小值继续二分查找
                min = mid + 1;
            }
        }
        return min;
    }

    /**
     * 判断不大于中间值的数字的数量是否大于等于k
     *
     * @param matrix n x n的有序矩阵
     * @param mid    中间值
     * @param k      第k小的元素
     * @param length 矩阵行数
     * @return 不大于中间值的数字的数量是否大于等于k
     */
    public static boolean check(int[][] matrix, int mid, int k, int length) {
        // i表示第一个数组的最后一个数，j表示最后一个数组的第一个元素
        int i = length - 1;
        int j = 0;
        int num = 0;
        // 根据此矩阵的特点，从左下角开始使用二分法判断有多少小于等于mid的值，如果数量>=k说明结果<=mid
        while (i >= 0 && j < length) {
            // 从左下角开始沿对角线往右上角遍历
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
