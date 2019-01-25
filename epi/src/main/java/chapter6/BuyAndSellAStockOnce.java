package chapter6;

import java.util.List;

/**
 * Write a program that takes an array denoting the daily stock price,
 * and returns the maximum profit that could be made by buying and then selling one share of that stock.
 */
public class BuyAndSellAStockOnce {
  public static double computeMaxProfit(List<Double> prices) {
    double minimumSoFar = Double.MAX_VALUE;
    double maxProfit = 0;
    for (double price: prices) {
      maxProfit = Math.max(maxProfit, price - minimumSoFar);
      minimumSoFar = Math.min(minimumSoFar, price);
    }
    return maxProfit;
  }
}
