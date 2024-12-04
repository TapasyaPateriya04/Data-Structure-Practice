public class MakeStringASubsequenceUsingCyclicIncrements {

    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        
        while (i < str1.length()) {
            
            if (str1.charAt(i) == str2.charAt(j) || 
                (str1.charAt(i) + 1 == str2.charAt(j)) || 
                (str1.charAt(i) == 'z' && str2.charAt(j) == 'a')) {
                j++;
                if (j == str2.length())
                    return true;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        String str1="abcd";
        String str2="ad";
        MakeStringASubsequenceUsingCyclicIncrements soln= new MakeStringASubsequenceUsingCyclicIncrements();
        boolean ans=soln.canMakeSubsequence(str1, str2);
        System.out.println(ans);
    }
}