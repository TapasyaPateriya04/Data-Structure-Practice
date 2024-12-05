public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String start ="_L__R__R_" , target = "L______RR";
        MovePiecesToObtainAString soln = new MovePiecesToObtainAString();
        System.out.println("Answer is :" + soln.canChange(start, target));

    }

    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            
            if (i == n || j == n) {
                return i == j;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        while (i < n) {
            if (start.charAt(i++) != '_') return false;
        }
        while (j < n) {
            if (target.charAt(j++) != '_') return false;
        }

        return true;
    }
    
}
