import java.util.HashSet;

public class MaximumNumberOfIntegersToChooseFromARangeI {

    
        public static void main(String[] args) {
            MaximumNumberOfIntegersToChooseFromARangeI soln =new MaximumNumberOfIntegersToChooseFromARangeI();
            int n=7,maxSum=30;
            int [] banned ={10,23};
            System.out.println("The count is: " + soln.maxCount(banned, n, maxSum));
    }
    
     public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> banNum = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            banNum.add(banned[i]);
        }
        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) { 
            if (!banNum.contains(i) && sum + i <= maxSum) { 
                count++;
                sum += i;
            } else if (sum + i > maxSum) {
                break;
            }
        }
        return count;
    }
}
