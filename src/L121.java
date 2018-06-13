public class L121 { //buy and sell stock
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int min = prices[0] ;
        int cur = 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            cur = prices[i] - min ;
            max =  cur > max ? cur : max;
            min = min > prices[i] ? prices[i] : min;
        }
        if(max > 0 )
            return max;
        else
            return 0;
    }
}
