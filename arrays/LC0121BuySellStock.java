/*
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Approach: One pass, tracking the minimum price so far
 * Time: O(n) | Space: O(1)
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            best = Math.max(best, price - minPrice);
        }
        return best;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
        System.out.println(s.maxProfit(new int[]{2, 4, 1}));          // 2
    }
}
