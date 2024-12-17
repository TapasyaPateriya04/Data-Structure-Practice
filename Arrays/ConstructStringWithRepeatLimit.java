public class ConstructStringWithRepeatLimit {

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit soln = new ConstructStringWithRepeatLimit();
        System.out.println(soln.repeatLimitedString("cccaaa", 2));
    }   

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCount = new int[26];

        for (char ch : s.toCharArray())
            charCount[ch - 'a']++;

        int nextChar = -1;
        StringBuilder result = new StringBuilder();

        for (int current = 25; current >= 0; current--) {
            if (charCount[current] == 0)
                continue;

            if (nextChar > 0) {
                result.append((char) ('a' + current));
                charCount[current]--;
                current = nextChar;
                nextChar = -1;

            } else {
                for (int limit = 0; limit < repeatLimit && charCount[current] > 0; limit++, charCount[current]--)
                    result.append((char) ('a' + current));

                if (charCount[current] > 0)
                    nextChar = current + 1;
            }
        }
        
        return result.toString();
    }
    
}
