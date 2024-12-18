import java.util.Arrays;

public class FinalPricesWithASpecialDiscountInAShop {
   
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        FinalPricesWithASpecialDiscountInAShop soln = new FinalPricesWithASpecialDiscountInAShop();
        System.out.println("Final prices are: " + Arrays.toString(soln.finalPrices(prices)));  
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = prices[i];

            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        
        return res;
    }
}
