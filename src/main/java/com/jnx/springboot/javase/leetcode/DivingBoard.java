package com.jnx.springboot.javase.leetcode;

import java.util.Arrays;

/**
 * [面试题 16.11]跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，
 * 长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * Related Topics 递归 记忆化
 *
 * @author 蒋楠鑫
 * @date 2020/7/8
 */
public class DivingBoard {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(1, 3, 4)));
    }

    /**
     * 跳水板所有可能的长度的数组（从小到大排序）
     *
     * @param shorter 较短的木板的长度
     * @param longer  较长的模板的长度
     * @param k       使用的木板的个数
     * @return 跳水板所有可能的长度
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        // k为0时返回空数组
        if (k == 0) {
            return new int[0];
        }
        // 最长和最短相等时说明只有一种组合
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        // 所有可能的长度一共k+1种
        int[] arr = new int[k + 1];
        // 最小的长度为k*shorter，最大长度为k*longer，每次将1一个shorter替换为longer
        for (int i = 0; i <= k; i++) {
            arr[i] = (k - i) * shorter + i * longer;
        }
        return arr;
    }
}
