import java.util.Scanner;
import java.math.BigInteger;

public class LongIntegerMultiplication
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        String num1 = sc.nextLine();
        System.out.println("Enter second number: ");
        String num2 = sc.nextLine();

        BigInteger x = new BigInteger(num1);
        BigInteger y = new BigInteger(num2);

        BigInteger result = longMultiplication(x, y);
        System.out.println("The result is: " + result);
        sc.close();
    }

    public static BigInteger longMultiplication(BigInteger x, BigInteger y)
    {
        int n = Math.max(x.bitLength(), y.bitLength());
        if (n <= 2000) 
        {
            // base case
            return x.multiply(y);
        }
        // dividing x and y into two parts
        int mid = n / 2;
        BigInteger xl = x.shiftRight(mid);
        BigInteger xr = x.subtract(xl.shiftLeft(mid));
        BigInteger yl = y.shiftRight(mid);
        BigInteger yr = y.subtract(yl.shiftLeft(mid));
        // recursive calls to multiply the divided parts
        BigInteger P1 = longMultiplication(xl, yl);
        BigInteger P2 = longMultiplication(xr, yr);
        BigInteger P3 = longMultiplication(xl.add(xr), yl.add(yr));
        // computing the final result using the formula
        return P1.shiftLeft(2 * mid).add(P3.subtract(P1).subtract(P2).shiftLeft(mid)).add(P2);
    }
}
