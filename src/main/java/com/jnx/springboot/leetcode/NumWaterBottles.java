package com.jnx.springboot.leetcode;

/**
 * [1518]换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 * Related Topics 贪心算法
 *
 * @author 蒋楠鑫
 * @date 2020/10/15
 */
public class NumWaterBottles {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        // 喝到酒的总数和空酒瓶的总数初始值为均为已购买的m瓶酒
        int drinked = numBottles;
        int empty = numBottles;
        // 判断空瓶数量是否可以继续换酒
        while ((empty / numExchange) != 0) {
            // 空瓶换酒
            int changed = empty / numExchange;
            // 喝掉换来的酒
            drinked += changed;
            // 空瓶数量=换酒剩下的空瓶+喝掉换来的酒的空瓶
            empty = empty % numExchange + changed;
        }
        return drinked;
    }
}
