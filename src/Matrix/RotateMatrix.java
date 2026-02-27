package Matrix;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {

        System.out.println("Welcome to Rotate Matrix Problem");

        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // ---------------- MATRIX 1 ----------------
        System.out.println("Input Matrix1:");
        printMatrix(matrix1);

        System.out.println("Brute Force Result Matrix1:");
        printMatrix(rotateBrute(matrix1));

        System.out.println("Optimized Result Matrix1:");
        rotateOptimized(matrix1);
        printMatrix(matrix1);

        // Expected Output:
        // [3, 1]
        // [4, 2]


        // ---------------- MATRIX 2 ----------------
        System.out.println("Input Matrix2:");
        printMatrix(matrix2);

        System.out.println("Brute Force Result Matrix2:");
        printMatrix(rotateBrute(matrix2));

        System.out.println("Optimized Result Matrix2:");
        rotateOptimized(matrix2);
        printMatrix(matrix2);

        // Expected Output:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
    }

    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH (Using Extra Matrix)
    // ------------------------------------------------------------
    // Idea:
    // Create a new matrix and map each element:
    //
    // matrix[row][col] → result[col][n - 1 - row]
    //
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2) ❌ (extra matrix)
    // ------------------------------------------------------------

    public static int[][] rotateBrute(int[][] matrix) {

        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                result[col][n - 1 - row] = matrix[row][col];
            }
        }

        return result;
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (In-place Rotation)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Reverse the matrix vertically (swap rows)
    // 2️⃣ Transpose the matrix (swap across diagonal)
    //
    // Time Complexity: O(n^2)
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static void rotateOptimized(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return;

        int n = matrix.length;

        // -------- Step 1: Reverse vertically --------
        for (int top = 0, bottom = n - 1; top < bottom; top++, bottom--) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
        }

        // -------- Step 2: Transpose --------
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
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