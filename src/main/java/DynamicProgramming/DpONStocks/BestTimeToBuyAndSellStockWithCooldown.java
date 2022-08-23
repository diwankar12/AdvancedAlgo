package DynamicProgramming.DpONStocks;

class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length+2][2] ;

        for(int i =prices.length-1 ;i>=0;i--){
            for(int buy = 0 ;buy<=1;buy++){

                int profit = 0 ;
                if(buy==0){
                    profit = Math.max(-prices[i] + dp[i+1][1] ,dp[i+1][0] );
                } else {
                    profit = Math.max(dp[i+2][0] + prices[i],dp[i+1][1]);
                }
                dp[i][buy] = profit ;
            }
        }
        return dp[0][0] ;

    }



    public int maxProfitMemo(int[] prices) {

        int[][] dp = new int[prices.length][2] ;
        return helper(prices,0,0,dp);

    }


    private int helper(int[] prices,int i,int buy,int[][] dp){


        if(i>=prices.length) return 0 ;

        int profit = 0;

        if(dp[i][buy]!=0) return dp[i][buy] ;

        if(buy==0){
            profit = Math.max(-prices[i]+helper(prices,i+1,1,dp),helper(prices,i+1,0,dp)) ;
        } else {
            profit = Math.max(prices[i]+helper(prices,i+2,0,dp),helper(prices,i+1,1,dp));
        }

        return dp[i][buy] = profit ;


    }




}