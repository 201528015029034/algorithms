package Num309BestTimetoBuyandSellStockwithCooldown;

/**
 * Created by test on 2017/4/24.
 */
public class Solution {
    int[] profits;
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        profits = new int[prices.length+2];
        for(int i=0; i<prices.length; i++) {
            profits[i] = Integer.MIN_VALUE;
        }
        profits[prices.length] = 0;
        profits[prices.length+1] = 0;
        int max = 0;
        int tmp = 0;
        for(int i=prices.length-1; i>=0; i--) {
            tmp =  maxProfit(prices, prices[i], i);
            max = max > tmp ? max : tmp;
        }
        for(int i : profits) {
            System.out.print(i + " ");
        }
        return max;
    }

    private int maxProfit(int[] prices, int minPrice, int pos) {
        int max = 0;
        int tmp = 0;
        for(int i=pos; i<prices.length; i++) {
            if(prices[i] > minPrice) {
                if(profits[i+2] == Integer.MIN_VALUE) {
                    profits[i+2] = maxProfit(prices, i+2 < prices.length-1 ? prices[i+2] : 0, i+2);
                }
                tmp = prices[i] - minPrice + profits[i+2];
            }
            max = max > tmp ? max : tmp;
        }

        if(max == 0 && profits[pos+1] > 0) {
            max = profits[pos+1];
        }
        profits[pos] = max;

        return profits[pos];
    }
}
