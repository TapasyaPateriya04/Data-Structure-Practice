public class BuyAndSellStock {

    // public int maxProfit(int[] prices) {
    //     int maxProfit = Integer.MIN_VALUE;
    //     for (int i = 0; i < prices.length; i++) {
    //         for (int j = i + 1; j < prices.length; j++) {                        //     O(n^2)
    //                                                                             //    Brute Force
    //             maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
    //         }                                                                      
    //     }
    //     return maxProfit > 0 ? maxProfit : 0;
    // }

public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
                                                       //          O(n)
        for (int i = 0; i < prices.length; i++) {     //        Optimised

            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock solution = new BuyAndSellStock();
        int[] nums ={ 7,1,5,3,6,4} ;
        System.out.println("Maximum Profit: " + solution.maxProfit(nums));
    }
    
}
