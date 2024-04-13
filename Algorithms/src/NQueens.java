import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens
{
    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> solutions = new ArrayList<>();
        int[][] board = new int[n][n];
        placeQueens(board, 0, solutions);
        return solutions;
    }

    private static void placeQueens(int[][] board, int row, List<List<String>> solutions) 
    {
        int n = board.length;
        if (row == n)
        {
            solutions.add(generateSolution(board));
            return;
        }
        for (int col = 0; col < n; col++) 
        {
            if (isSafe(board, row, col)) 
            {
                board[row][col] = 1;
                placeQueens(board, row + 1, solutions);
                board[row][col] = 0; // Backtracking
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col)
    {
        int n = board.length;

        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) 
        {
            if (board[i][col] == 1)
            {
                return false;
            }
        }

        // Check if there is a queen in the left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) 
        {
            if (board[i][j] == 1) 
            {
                return false;
            }
        }

        // Check if there is a queen in the right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) 
        {
            if (board[i][j] == 1) 
            {
                return false;
            }
        }

        return true;
    }

    private static List<String> generateSolution(int[][] board)
    {
        List<String> solution = new ArrayList<>();
        for (int[] row : board) 
        {
            StringBuilder sb = new StringBuilder();
            for (int cell : row)
            {
                sb.append(cell == 1 ? 'Q' : '.');
            }
            solution.add(sb.toString());
        }
        return solution;
    }

    public static void main(String[] args) 
    {
    	Scanner S = new Scanner(System.in);
    	System.out.println("Enter value of n : ");
        int n = S.nextInt();
        List<List<String>> solutions = solveNQueens(n);
        System.out.println("Number of solutions: " + solutions.size());
        for (List<String> solution : solutions)
        {
            for (String row : solution) 
            {
                System.out.println(row);
            }
            System.out.println();
        }
        S.close();
    }
}
