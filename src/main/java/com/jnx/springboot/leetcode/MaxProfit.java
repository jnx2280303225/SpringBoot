package com.jnx.springboot.leetcode;

/**
 * [309]最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * Related Topics 动态规划
 *
 * @author 蒋楠鑫
 * @date 2020/7/10
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    /**
     * 计算最大利润
     *
     * @param prices 股票的价格数组（第i个元素代表了第i天的股票价格）
     * @return 最大利润
     */
    public static int maxProfit(int[] prices) {
        // 如果价格数组为空直接返回利润为0
        if (prices.length == 0) {
            return 0;
        }
        // 动态规划分三种情况1.持有股票，2.不持有股票并且在冻结期，3.不持有股票并且不在冻结期。前三项为固定值，第1天持有股票的收益
        int profit0 = -prices[0];
        // 第一天不持有股票且在冻结期，这种情况不存在，但是为了函数的连续性，假定这种情况
        int profit1 = 0;
        // 第一天不持有股票且不在冻结期
        int profit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newProfit0 = Math.max(profit0, profit2 - prices[i]);
            int newProfit1 = profit0 + prices[i];
            int newProfit2 = Math.max(profit1, profit2);
            profit0 = newProfit0;
            profit1 = newProfit1;
            profit2 = newProfit2;
        }
        return Math.max(profit1, profit2);
    }
}
