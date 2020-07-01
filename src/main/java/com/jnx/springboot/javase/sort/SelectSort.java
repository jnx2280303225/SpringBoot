package com.jnx.springboot.javase.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author 蒋楠鑫
 * @date 2020-02-17
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 10, 2, 6, 7, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序算法
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        //外层循环总共需要n-1次,最后一个数的位置固定
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //里层循环从i+1开始
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
