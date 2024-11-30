public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }                                                                      
        }
        return maxProfit > 0 ? maxProfit : 0;
    }

    public static void main(String[] args) {
        BuyAndSellStock solution = new BuyAndSellStock();
        int[] nums ={ 7,1,5,3,6,4} ;
        System.out.println("Maximum Profit: " + solution.maxProfit(nums));
    }
    
}
