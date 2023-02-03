import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {
    public static ArrayList<Integer> fibonacci(int n) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>(Arrays.asList(1, 1));
        if (n < 3) {
            return fibonacciNumbers;
        }
        for (int fibonacciIndex = 3; fibonacciIndex <= n; fibonacciIndex++) {
            int previousNumber = fibonacciNumbers.get(fibonacciIndex - 2);
            int prevPreviousNumber = fibonacciNumbers.get(fibonacciIndex - 3);
            fibonacciNumbers.add(previousNumber + prevPreviousNumber);
        }
        return fibonacciNumbers;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci series");
        System.out.println(fibonacci(15).toString());
    }
}
