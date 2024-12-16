public class FinalArrayStateAfterKMultiplicationOperationsI {
    
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 3, multiplier = 4;
        FinalArrayStateAfterKMultiplicationOperationsI soln = new FinalArrayStateAfterKMultiplicationOperationsI();
        System.out.println(java.util.Arrays.toString(soln.getFinalState(nums, k, multiplier)));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int[] minInfo = getMin(nums); // Find the minimum value and its index
            int minValue = minInfo[0];
            int idx = minInfo[1];

            // Multiply the minimum value by the multiplier
            nums[idx] = minValue * multiplier;
        }

        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = -1; // to store the index of the minimum element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }
        }

        return new int[] { min, idx }; // Return both the min value and its index
    }
}
