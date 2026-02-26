package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        System.out.println("Welcome to Spiral Matrix Problem");

        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Brute Force Result Matrix1: " + spiralOrderBrute(matrix1));
        System.out.println("Optimized Result Matrix1: " + spiralOrderOptimized(matrix1));

        System.out.println("Brute Force Result Matrix2: " + spiralOrderBrute(matrix2));
        System.out.println("Optimized Result Matrix2: " + spiralOrderOptimized(matrix2));
    }

    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Walk in 4 directions (Right, Down, Left, Up)
    // Maintain a visited[][] array
    // If next cell is invalid or visited → change direction
    //
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)  ← Extra visited array
    // ------------------------------------------------------------

    public static List<Integer> spiralOrderBrute(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        // Direction arrays → Right, Down, Left, Up
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        int direction = 0;   // Start moving right
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {

            result.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + rowDir[direction];
            int nextCol = col + colDir[direction];

            // If next cell is out of bounds OR already visited
            // → change direction
            if (nextRow < 0 || nextRow >= m ||
                    nextCol < 0 || nextCol >= n ||
                    visited[nextRow][nextCol]) {

                direction = (direction + 1) % 4;
            }

            row += rowDir[direction];
            col += colDir[direction];
        }

        return result;
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Boundary Shrinking)
    // ------------------------------------------------------------
    // Idea:
    // Instead of using visited array,
    // maintain 4 boundaries:
    // top, bottom, left, right
    //
    // Traverse layer by layer.
    //
    // Time Complexity: O(m*n)
    // Space Complexity: O(1) extra
    // ------------------------------------------------------------

    public static List<Integer> spiralOrderOptimized(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Left → Right (Top Row)
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2️⃣ Top → Bottom (Right Column)
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3️⃣ Right → Left (Bottom Row)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4️⃣ Bottom → Top (Left Column)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}