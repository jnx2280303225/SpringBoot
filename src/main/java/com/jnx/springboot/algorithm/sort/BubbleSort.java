package com.jnx.springboot.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author 蒋楠鑫
 * @date 2020-02-17
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 10, 2, 6, 7, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序算法
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        //外层循环n-1次
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                //比较相邻两个数的大小
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
