public class FindLongestSpecialSubstringThatOccursThriceI {


    public static void main(String[] args) {
        String s="aaaa";
        FindLongestSpecialSubstringThatOccursThriceI soln = new FindLongestSpecialSubstringThatOccursThriceI();
        System.out.println(soln.maximumLength(s));
    }

    private boolean helper(String s, int n, int x) {
        int[] charCount = new int[26];
        int start = 0;

        for (int end = 0; end < n; end++) {
            while (s.charAt(start) != s.charAt(end)) {
                start++;
            }
            if (end - start + 1 >= x) {
                charCount[s.charAt(end) - 'a']++;
            }
            if (charCount[s.charAt(end) - 'a'] > 2) {
                return true;
            }
        }

        return false;
    }
    
    public int maximumLength(String s) {
        int n = s.length();
        int left = 1, right = n;

        if (!helper(s, n, left)) return -1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (helper(s, n, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}