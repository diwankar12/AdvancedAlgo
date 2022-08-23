package DynamicProgramming.DpONStocks;

class BuyAndSellStocks1 {
    public int maxProfit(int[] prices) {

        int profit = 0 ;
        int min = Integer.MAX_VALUE ;

        for(int i=0;i<prices.length;i++){

            int cost = prices[i] - min ;
            profit = Math.max(cost,profit) ;
            min = Math.min(min,prices[i]);
        }
        return profit ;
    }

}