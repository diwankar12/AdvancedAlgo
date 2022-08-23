package DynamicProgramming.DpONStocks;

class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k ,int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1] ;

        for(int i=prices.length-1;i>=0;i--){
            for(int buy =0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    int profit = 0 ;
                    if(buy==0){
                        profit = Math.max(-prices[i] + dp[i+1][1][cap] ,dp[i+1][0][cap] );

                    } else {
                        profit = Math.max(dp[i+1][0][cap-1]+ prices[i],dp[i+1][1][cap]);

                    }
                    dp[i][buy][cap] = profit ;
                }
            }
        }

        return dp[0][0][k] ;



    }


    public int maxProfitMemo(int[] prices) {

        int[][][] dp = new int[prices.length][2][3] ;
        return helper(0,prices,0,2,dp) ;

    }

    private int helper(int i,int[] prices , int buy,int cap,int[][][] dp){

        if(cap==0) return 0 ;
        if(i==prices.length) return 0 ;
        int profit = 0 ;
        if(dp[i][buy][cap]!=0) return dp[i][buy][cap] ;
        if(buy==0){
            profit = Math.max(-prices[i] + helper(i+1,prices,1,cap,dp) ,helper(i+1,prices,0,cap,dp) );

        } else {
            profit = Math.max(helper(i+1,prices,0,cap-1,dp) + prices[i],helper(i+1,prices,1,cap,dp));

        }
        return dp[i][buy][cap] = profit ;
    }




}