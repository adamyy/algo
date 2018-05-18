package recursions_dynamic_programming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times)
 * with the following restrictions:
 * - You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * - After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;
    // max profit till index i w/ the series of transaction ends with a buy
    int[] buy = new int[prices.length];
    // max profit till index i w/ the series of transaction ends with a sell
    int[] sell = new int[prices.length];

    // initial states
    buy[0] = - prices[0]; // we can buy at i = 0, max profit is -prices[0]
    buy[1] = Math.max(-prices[0], -prices[1]); // we cannot buy twice as we must sell our stock first
    sell[0] = 0; // we cannot sell, thus max profit is 0
    sell[1] = Math.max(prices[1] - prices[0], sell[0]); // we might be able to sell or we can choose not to

    for (int i = 2; i < prices.length; i++) {
      buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
      sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    }
    return sell[prices.length - 1];
  }

  public static int maxProfitSimplified(int[] prices) {
    int sell = 0;
    int sellPrev = 0;
    int buy = Integer.MIN_VALUE;
    int buyPrev;

    for (int price : prices){
      buyPrev = buy;
      buy = Math.max(sellPrev - price, buyPrev);
      sellPrev = sell;
      sell = Math.max(buyPrev + price, sellPrev);
    }

    return sell;
  }
}
