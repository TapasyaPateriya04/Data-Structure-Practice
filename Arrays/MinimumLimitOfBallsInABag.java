import java.util.Arrays;

public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        int num =4;
        int [] arr={2,4,8,2};
        MinimumLimitOfBallsInABag soln =new MinimumLimitOfBallsInABag();
        System.out.println(soln.minimumSize(arr, num));
    }


    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        
        while (left < right) {
            int penalty = (left + right) / 2;
            int operationsNeeded = 0;
            
            for (int num : nums) {
                operationsNeeded += (num - 1) / penalty;
            }
            
            if (operationsNeeded <= maxOperations) {
                right = penalty;
            } else {
                left = penalty + 1;
            }
        }
        
        return right;
    }
    
}
