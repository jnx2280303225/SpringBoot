package com.jnx.springboot.leetcode;

import java.util.PriorityQueue;

/**
 * [703]数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返
 * 回当前数据流中第K大的元素。
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * Related Topics 堆
 *
 * @author 蒋楠鑫
 * @date 2020/9/25
 */
public class KthLargest {

    /**
     * 第k大的元素
     */
    private int k;

    /**
     * 优先队列
     */
    private PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        // 初始化优先队列（构造最小堆）
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * 每次添加一个元素，调整堆的结构，返回第k大的元素
     *
     * @param val 要添加的元素
     * @return 第k大的元素
     */
    public int add(int val) {
        // 如果当前优先队列的容量<k直接放入元素
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            // 如果优先队列的容量=k，且新添加的元素比最小堆的堆顶元素要大，将堆顶元素取出，放入新元素
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {5};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
    }
}
