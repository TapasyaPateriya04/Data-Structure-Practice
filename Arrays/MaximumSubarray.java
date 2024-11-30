
public class MaximumSubarray {
    // public int maxSubArray(int[] nums) {
    //     int max = Integer.MIN_VALUE;
    //     int sum = 0;
        
    //     for (int i = 0; i < nums.length; i++) {            O(n^2)
    //                                                       Brute Force
    //         sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];
    //             max = Math.max(max, sum);
    //         }
    //     }
    //     return max;
    // }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; 
        int sum = 0;                
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];           
      //                                                     O(n)
      //                                                    optimised
            if (sum > max) {        
                max = sum;
            }
            
            if (sum < 0) {        
                sum = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums));
    }
}
