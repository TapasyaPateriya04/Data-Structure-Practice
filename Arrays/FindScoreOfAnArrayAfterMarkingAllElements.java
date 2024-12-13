public class FindScoreOfAnArrayAfterMarkingAllElements {
    
    public static void main(String[] args) {
        int [] nums={2,1,3,4,5,2};
        FindScoreOfAnArrayAfterMarkingAllElements soln= new FindScoreOfAnArrayAfterMarkingAllElements();
        System.out.println(soln.findScore(nums));
    } 

    public long findScore(int[] nums) {
        int len = nums.length;
        long total = 0;
        int left = 0, right = 0;
        while (right < len) {
            left = right;
            while (right + 1 < len && nums[right] > nums[right + 1]) {
                right++;
            }
            for (int i = right; i >= left; i -= 2) {
                total += nums[i];
            }
            right += 2;
        }
        return total;
    }
}
