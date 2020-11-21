package com.jnx.springboot.leetcode;

/**
 * [122]买卖股票的最佳时机II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * Related Topics 贪心算法 数组
 *
 * @author 蒋楠鑫
 * @date 2020/9/27
 */
public class MaxProfitTwo {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }

    /**
     * 解法一：暴力枚举（递归思想）
     * 列举所有的交易情况，找出其中最大的利润
     *
     * @param prices 股票价格的数组
     * @return 最大的利润
     */
    public static int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    /**
     * 递归枚举出所有的交易情况，并计算最大利润
     *
     * @param prices 股票价格的数组
     * @param index  当前数组的索引
     * @return 当前所有交易情况可获得的最大利润
     */
    private static int calculate(int[] prices, int index) {
        // 递归出口，超过数据长度之后再卖出，利润均为0
        if (index >= prices.length) {
            return 0;
        }
        int max = 0;
        // 从index开始遍历，假设第index天买入
        for (int start = index; start < prices.length; start++) {
            int maxProfit = 0;
            // 从start+1开始遍历，假设买入1天之后开始卖出获得收益
            for (int end = start + 1; end < prices.length; end++) {
                // 卖出之后的第二天继续买入，然后卖出，递归计算总收益
                int profit = prices[end] - prices[start] + calculate(prices, end + 1);
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

    /**
     * 解法二：峰谷法
     * 找到紧跟着谷底的最近一个峰值，每次都采用谷底买，峰值卖，获得最大利润
     *
     * @param prices 股票价格的数组
     * @return 最大的利润
     */
    public static int maxProfit2(int[] prices) {
        int index = 0;
        int maxProfit = 0;
        int buy;
        int sell;
        // 遍历所有的价格
        while (index < prices.length - 1) {
            // 先遍历找到最近的谷底买入股票
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            buy = prices[index];
            // 再遍历找到离谷底最近的峰值，卖出股票获得利润
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            sell = prices[index];
            maxProfit += sell - buy;
        }
        return maxProfit;
    }

    /**
     * 解法三：贪心算法
     * 要想获得最大利润，那么只要保证每次买卖都获利（子问题最优解），然后尽可能进行最多次的交易即可，
     * 只要满足prices[i] > prices[i-1]就再第i-1天买入，第i天卖出，买卖次数越多利润越高。
     *
     * @param prices 股票价格的数组
     * @return 最大的利润
     */
    public static int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只要当天价格高于前一天就在进行买卖交易
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
