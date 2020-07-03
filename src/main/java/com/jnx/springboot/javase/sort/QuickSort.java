package com.jnx.springboot.javase.sort;

import java.util.Arrays;

/**
 * 快速排序（分治思想）
 *
 * @author 蒋楠鑫
 * @date 2020-02-17
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {4, 1, 10, 2, 6, 7, 3, 9, 5};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	/**
     * 快速排序算法（递归）
     *
     * @param arr   数组
     * @param start 初始索引
     * @param end   结束索引
     */
    public static void sort(int[] arr, int start, int end) {
        //递归出口
        if (start > end) {
            return;
        }
        //i=起始索引,j=结束索引,mid=基准值,temp交换值时使用
        int temp;
        int i = start;
        int j = end;
        int mid = arr[start];
        //遍历集合
        while (i < j) {
            //左边往右递增
            while (mid > arr[i] && i < j) {
                i++;
            }
            //右边往左递减
            while (mid < arr[j] && i < j) {
                j--;
            }
            //满足条件交换值
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //左边继续递归
            sort(arr, start, j - 1);
            //右边继续递归
            sort(arr, j + 1, end);
		}
	}
}
