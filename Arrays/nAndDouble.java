import java.util.HashSet;

public class nAndDouble {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) { 
            if (seen.contains(arr[i] * 2) || (arr[i] % 2 == 0 && seen.contains(arr[i] / 2))) {
                return true;
            }
            seen.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        nAndDouble soln = new nAndDouble();
        System.out.println(soln.checkIfExist(arr));
    }
}
