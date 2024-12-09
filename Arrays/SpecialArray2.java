import java.util.Arrays;

public class SpecialArray2 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 6};
        int[][] queries = {{0, 4}};
        SpecialArray2 soln = new SpecialArray2();
        System.out.println(Arrays.toString(soln.isArraySpecial(nums, queries)));
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] specialCountPrefix = new int[n];
        boolean[] results = new boolean[queries.length];

        for (int i = 1; i < n; i++) {
            specialCountPrefix[i] = specialCountPrefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) || 
                (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                specialCountPrefix[i]++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int specialPairs = specialCountPrefix[end] - (start > 0 ? specialCountPrefix[start] : 0);
            results[i] = (specialPairs == 0);
        }

        return results;
    }
}
