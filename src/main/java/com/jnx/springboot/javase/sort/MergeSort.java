package com.jnx.springboot.javase.sort;

import java.util.Arrays;

/**
 * 归并排序（先利用分治法拆分成多个小数组排序，最后合并成大数组）
 *
 * @author 蒋楠鑫
 * @date 2020/7/2
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 10, 2, 6, 7, 3, 9, 5};
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 分治思想将大数组拆分成多个小数组
     *
     * @param arr   完整的大数组
     * @param start 开始索引
     * @param end   结束索引
     */
    public static void sort(int[] arr, int start, int end) {
        // 如果只有一个元素就不用排序了
        if (start >= end) {
            return;
        }
        // 去中间索引，将数组拆分成两个小数组
        int mid = (start + end) / 2;
        // 左边继续拆分
        sort(arr, start, mid);
        // 右边继续拆分
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将小数组合并成大数组
     *
     * @param arr   拆分后的小数组
     * @param start 开始索引
     * @param mid   拆分的中间索引
     * @param end   结束索引
     */
    public static void merge(int[] arr, int start, int mid, int end) {
        // 构造左右两个小数组并按照索引填充元素
        int[] leftArr = Arrays.copyOfRange(arr, start, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, end + 1);
        // 左右两个数组的开始索引
        int leftIndex = 0;
        int rightIndex = 0;
        // 大数组当前放入的元素的指针
        int index = start;
        // 每次比较两个小数组的元素，将较小的放入大数组
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                arr[index] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[index] = rightArr[rightIndex];
                rightIndex++;
            }
            index++;
        }
        // 如果左边还有没比较的，右边已经遍历完了，将左边剩余的元素复制到大数组
        while (leftIndex < leftArr.length) {
            arr[index] = leftArr[leftIndex];
            leftIndex++;
            index++;
        }
        // 如果右边还有没比较的，左边已经遍历完了，将右边剩余的元素复制到大数组
        while (rightIndex < rightArr.length) {
            arr[index] = rightArr[rightIndex];
            rightIndex++;
            index++;
        }
    }
}
