package Matrix;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {

        System.out.println("Welcome to Set Matrix Zeroes Problem");

        int[][] matrix1 = {
                {0, 1},
                {1, 0}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8}
        };

        // ---------------- MATRIX 1 ----------------
        System.out.println("Input Matrix1:");
        printMatrix(matrix1);

        System.out.println("Brute Force Result Matrix1:");
        printMatrix(setZeroesBrute(matrix1));

        System.out.println("Optimized Result Matrix1:");
        setZeroesOptimized(matrix1);
        printMatrix(matrix1);

        // Expected Output:
        // [0, 0]
        // [0, 0]


        // ---------------- MATRIX 2 ----------------
        System.out.println("Input Matrix2:");
        printMatrix(matrix2);

        System.out.println("Brute Force Result Matrix2:");
        printMatrix(setZeroesBrute(matrix2));

        System.out.println("Optimized Result Matrix2:");
        setZeroesOptimized(matrix2);
        printMatrix(matrix2);

        // Expected Output:
        // [1, 0, 3]
        // [0, 0, 0]
        // [6, 0, 8]
    }

    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH (Using Extra Matrix)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Create a copy matrix
    // 2️⃣ Whenever we find 0 in original matrix,
    //    set entire row and column to 0 in copy matrix
    //
    // Time Complexity: O((m*n)*(m+n)) ❌
    // Space Complexity: O(m*n) ❌
    // ------------------------------------------------------------

    public static int[][] setZeroesBrute(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] copy = new int[m][n];

        // Copy original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {

                    // Zero entire row
                    for (int col = 0; col < n; col++) {
                        copy[i][col] = 0;
                    }

                    // Zero entire column
                    for (int row = 0; row < m; row++) {
                        copy[row][j] = 0;
                    }
                }
            }
        }

        return copy;
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (In-place using first row & column)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Use first row as column marker
    // 2️⃣ Use first column as row marker
    // 3️⃣ Use extra boolean to track first row separately
    //
    // Time Complexity: O(m*n)
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static void setZeroesOptimized(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;

        // -------- Step 1: Check if first row contains zero --------
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // -------- Step 2: Mark rows and columns --------
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;   // Mark row
                    matrix[0][j] = 0;   // Mark column
                }
            }
        }

        // -------- Step 3: Zero inner matrix --------
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // -------- Step 4: Handle first column --------
        if (matrix[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // -------- Step 5: Handle first row --------
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }


    // ------------------------------------------------------------
    // Utility Function to Print Matrix
    // ------------------------------------------------------------

    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}