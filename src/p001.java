/**
 * p001
 */
import java.util.ArrayList;

// Problem 1
// Multiples of 3 and 5
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.

public class p001 {
    public boolean mod3(int x) {
        if (x % 3 == 0) {
            return true;
        }
        return false;
    }

    public boolean mod5(int x) {
        if (x % 5 == 0) {
            return true;
        }
        return false;
    }

    public int multiples(int x) {
        if (x < 1) { return 0; }
        ArrayList<Integer> mults = new ArrayList<Integer>();
        for (int i = 1; i < x; i++) {
            if (mod3(i) || mod5(i)) {
                mults.add(i);
            }
        }
        int result = mults
            .stream()
            .reduce(0, (subtotal, element) -> subtotal + element);
        return result;
    }

    public String run() {
        return Integer.toString(this.multiples(1000));
    }

    public static void main(String[] args) {
        System.out.println(new p001().run());
    }
}