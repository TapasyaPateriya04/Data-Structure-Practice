public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] isOriginallyZero = new boolean[rows][cols];

        // Mark cells that are originally zero
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    isOriginallyZero[row][col] = true;
                }
            }
        }

        // Set rows and columns to zero if originally zero
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isOriginallyZero[row][col]) {
                    for (int c = 0; c < cols; c++) {
                        matrix[row][c] = 0;
                    }
                    for (int r = 0; r < rows; r++) {
                        matrix[r][col] = 0;
                    }
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {      
            for (int j = 0; j < matrix[i].length; j++) { 
                System.out.print(matrix[i][j] + " "); 
            }
            System.out.println(); 
        }
    }  // <-- This closing brace was missing

    public static void main(String[] args) {
        SetMatrixZeroes soln = new SetMatrixZeroes();
        System.out.println("Input matrix is:");
        int[][] matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        printMatrix(matrix);

        System.out.println("New matrix is:");
        soln.setZeroes(matrix);
        printMatrix(matrix);
    }
}
