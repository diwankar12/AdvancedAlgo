package DynamicProgramming.DpONStocks;

class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[prices.length+1][2] ;

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit =0 ;
                if(buy==0){
                    profit= Math.max(-prices[i]+dp[i+1][1] ,dp[i+1][0]);
                } else {
                    profit = Math.max( -fee + prices[i]+dp[i+1][0],dp[i+1][1]) ;
                }
                dp[i][buy] = profit ;
            }
        }



        return dp[0][0];
    }



    public int maxProfitMemo(int[] prices, int fee) {

        int[][] dp = new int[prices.length][2] ;
        return helper(prices,fee,0,0,dp);
    }

    private int helper(int[] prices,int fee,int i,int buy,int[][] dp){

        if(i==prices.length) return 0 ;

        if(dp[i][buy]!=0) return dp[i][buy] ;

        int profit =0 ;

        if(buy==0){

            profit= Math.max(-prices[i]+helper(prices,fee,i+1,1,dp),helper(prices,fee,i+1,0,dp));
        } else {
            profit = Math.max( -fee + prices[i]+helper(prices,fee,i+1,0,dp),helper(prices,fee,i+1,1,dp)) ;
        }


        return dp[i][buy] = profit ;



    }




}