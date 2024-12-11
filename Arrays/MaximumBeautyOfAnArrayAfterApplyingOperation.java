public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    
    public static void main(String[] args) {
        int [] nums ={4,6,1,2};
        int k=2;
        MaximumBeautyOfAnArrayAfterApplyingOperation soln = new MaximumBeautyOfAnArrayAfterApplyingOperation();
        System.out.println(soln.maximumBeauty(nums,k));
    }

    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1)
            return 1;

        int maxB = 0;
        int maxN = 0;

        for (int n : nums)
            maxN = Math.max(maxN, n);

        int[] freq = new int[maxN + 1];

        for (int n : nums) {
            freq[Math.max(n - k, 0)]++;
            freq[Math.min(n + k + 1, maxN)]--;
        }

        int sum = 0;

        for (int f : freq) {
            sum += f;
            maxB = Math.max(maxB, sum);
        }

        return maxB;
    }
}
