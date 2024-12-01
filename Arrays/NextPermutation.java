import java.util.Arrays;

public class NextPermutation {

    // The nextPermutation method should be static or accessed correctly
    public void nextPermutation(int[] nums) {
        int breakpoint = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        if (breakpoint == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > breakpoint; i--) {
            if (nums[i] > nums[breakpoint]) {
                swap(nums, breakpoint, i);
                break;
            }
        }

        reverse(nums, breakpoint + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation(); // Correct object creation
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        solution.nextPermutation(nums); // Correct instance method call
        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }
}
