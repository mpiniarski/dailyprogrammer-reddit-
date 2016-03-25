/**
 * Created by marcin on 25.03.16.
 */
public class StockMarketSolver {
    public String findBestPair(String stockPrices) {
        double bestBuy = 0.0;
        double bestSell = 0.0;
        double bestIncome = 0.0;
        String[] stockPricesList = stockPrices.split(" ");
        for (int buyId = 0; buyId < stockPricesList.length - 2; buyId++) {
            for (int sellId = buyId + 2; sellId < stockPricesList.length; sellId++) {
                if (incomeFrom(stockPricesList[sellId], stockPricesList[buyId]) > bestIncome ){
                    bestBuy = Double.valueOf(stockPricesList[buyId]);
                    bestSell = Double.valueOf(stockPricesList[sellId]);
                    bestIncome = bestSell-bestBuy;
                }
            }
        }
        return String.valueOf(bestBuy) + " " + String.valueOf(bestSell);
    }

    private double incomeFrom(String buyPrice, String sellPrice) {
        return Double.valueOf(buyPrice) - Double.valueOf(sellPrice);
    }
}
