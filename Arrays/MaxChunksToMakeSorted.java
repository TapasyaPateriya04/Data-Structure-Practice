public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        MaxChunksToMakeSorted soln = new MaxChunksToMakeSorted();
        System.out.println("Max chunks to make sorted: " + soln.maxChunksToSorted(arr));
    }
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int cnt = 0, mx = 0;
        for (int i = 0; i < arr.length; i++) {
            mx = Math.max(mx, arr[i]);
            if (mx == i)
                cnt++;
        }

        return cnt;
    }
}