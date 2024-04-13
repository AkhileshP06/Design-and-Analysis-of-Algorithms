import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows <= 0) {
            return triangle;
        }
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            
            row.add(1); // First element of the row is always 1
            
            for (int j = 1; j < i; j++) {
                int num = prevRow.get(j - 1) + prevRow.get(j);
                row.add(num);
            }
            
            row.add(1); // Last element of the row is always 1
            
            triangle.add(row);
        }
        
        return triangle;
    }
    
    public static void main(String[] args) 
    {
    	Scanner S = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        List<List<Integer>> triangle = generate(S.nextInt());
        
        // Print the triangle
        for (List<Integer> row : triangle) 
        {
            for (int num : row) 
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        S.close();
    }
}
