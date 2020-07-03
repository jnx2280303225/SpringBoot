package com.jnx.springboot.javase.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author 蒋楠鑫
 * @date 2020/7/1
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 10, 2, 6, 7, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序算法
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        // 构造最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 第一个非叶子节点从下至上，从右至左调整
            adjustHeap(arr, i, arr.length);
        }
        // 调整堆结构+交换堆顶元素与末尾元素，升序排序
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 重新调整堆
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整最大堆
     *
     * @param arr    数组
     * @param index  当前非叶子节点索引
     * @param length 数组长度
     */
    private static void adjustHeap(int[] arr, int index, int length) {
        // 先取出当前索引的元素
        int temp = arr[index];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            // 如果左子结点小于右子结点，j指向右子结点
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
