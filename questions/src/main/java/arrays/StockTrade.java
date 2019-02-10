package arrays;

public class StockTrade {

  /**
   * Write a program that takes an array denoting the daily stock price,
   * and returns the maximum profit that could be made by buying and then selling
   * one share of that stock
   */
  public static int maxProfit(int[] prices) {
    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for (int price: prices) {
      maxProfit = Math.max(maxProfit, price - minPrice);
      minPrice = Math.min(minPrice, price);
    }

    return maxProfit;
  }

  /**
   * Write a program that computes the maximum profit that can be made by
   * buying and selling a share at most twice.
   * The second buy must be made on another date after the first sale.
   */
  public static int maxProfitTwoTrades(int[] prices) {
    int maxTotalProfit = 0;

    // forward phase
    // for each day, record maximum profit if we sell on that day
    int[] firstTradeProfits = new int[prices.length];
    int minPriceSoFar = Integer.MAX_VALUE;
    int maxFirstTradeProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
      maxFirstTradeProfit = Math.max(maxFirstTradeProfit, prices[i] - minPriceSoFar);
      firstTradeProfits[i] = maxFirstTradeProfit;
    }

    // backward phase
    // for each day, record maximum profit if we buy on that day
    int maxPriceSoFar = Integer.MIN_VALUE;
    int maxSecondTradeProfit = 0;
    for (int i = prices.length - 1; i > 0; i--) {
      maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
      maxSecondTradeProfit = Math.max(maxSecondTradeProfit, maxPriceSoFar - prices[i]);
      maxTotalProfit = Math.max(maxTotalProfit, maxSecondTradeProfit + firstTradeProfits[i]);
    }

    return maxTotalProfit;
  }

  public static int maxProfitTwoTradesConstantSpace(int[] prices) {
    return 0;
  }

  /**
   * In share trading, a buyer buys shares and sells on future date.
   * Given stock price of n days, the trader is allowed to make at most k transactions,
   * where new transaction can only start after previous transaction is complete,
   * find out maximum profit that a share trader could have made.
   */
  public static int maxProfitKTrades(int[] prices, int k) {
    // [day][number of transactions]
    // [whichever day][0] = 0 if you do no transaction
    return -1;
  }
}
