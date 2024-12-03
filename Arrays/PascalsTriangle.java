import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle soln = new PascalsTriangle();
        int numRows = 5;
        System.out.println("Pascal's triangle is : " + soln.generate(numRows));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));

        for (int rowNum = 0; rowNum < numRows - 1; rowNum++) {
            List<Integer> paddedRow = new ArrayList<>();
            paddedRow.add(0);
            paddedRow.addAll(triangle.get(triangle.size() - 1));
            paddedRow.add(0);
            
            List<Integer> newRow = new ArrayList<>();

            for (int col = 0; col < paddedRow.size() - 1; col++) {
                newRow.add(paddedRow.get(col) + paddedRow.get(col + 1));
            }

            triangle.add(newRow);
        }

        return triangle;        
    }
  


}
