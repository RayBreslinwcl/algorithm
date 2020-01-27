package com.algorithm.learn.Leetcode._122_best_time_to_buy_and_sell_stock_2;

/**
 * Created by Administrator on 2020/1/27.
 * 题目描述
 假设你有一个数组，其中第i个元素表示某只股票在第i天的价格。
 设计一个算法来寻找最大的利润。你可以完成任意数量的交易(例如，多次购买和出售股票的一股)。但是，你不能同时进行多个交易(即，你必须在再次购买之前卖出之前买的股票)。
 */
public class _122_best_time_to_buy_and_sell_stock_2 {
    public int maxProfit(int[] prices) {

        //错解：错误理解为一次买入卖出的误差
//        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
//        for (int price : prices) {
//            if(price<min){
//                min=price;
//            }
//            if (price>max){
//                max=price;
//            }
//        }
//        return max-min;

        if(prices.length<2){
            return 0;
        }
        int res=0;
        //注意i是从1开始，因为比较的是i和i-1
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
