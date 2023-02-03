import java.util.ArrayList;

public class Sieve {
    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        if (n < 2) {
            return new ArrayList<Integer>();
        }
        ArrayList<Boolean> sieveNumbers = new ArrayList<>();
        for (int arrayIndex = 0; arrayIndex <= n; arrayIndex++) {
            sieveNumbers.add(true);
        }
        int squareRootOfN = (int) Math.round(Math.sqrt(n));
        for (int arrayIndex = 2; arrayIndex <= squareRootOfN; arrayIndex++) {
            if (sieveNumbers.get(arrayIndex)) {
                for (int multiplesIndex = (arrayIndex*arrayIndex); multiplesIndex <= n; multiplesIndex += arrayIndex) {
                    sieveNumbers.set(multiplesIndex, false);
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int arrayIndex = 2; arrayIndex <= n; arrayIndex++) {
            if (sieveNumbers.get(arrayIndex)) {
                primes.add(arrayIndex);
            }
        }
        return primes;
    }

    public static ArrayList<Integer> sieveOfAtkin(int limit) {
        ArrayList<Boolean> sieve = new ArrayList<>();
        for (int sieveIndex = 0; sieveIndex <= limit; sieveIndex++) {
            sieve.add(false);
        }
        if (limit > 2) {
            sieve.set(2, true);
        }
        if (limit > 3) {
            sieve.set(3, true);
        }
        for (int x = 1; x * x <= limit; x++) {
            for (int y = 1; y * y <= limit; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    sieve.set(n, !sieve.get(n));
                }
                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7) {
                    sieve.set(n, !sieve.get(n));
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11) {
                    sieve.set(n, !sieve.get(n));
                }
            }
        }
        for (int r = 5; r * r <= limit; r++) {
            if (sieve.get(r)) {
                for (int i = r * r; i <= limit; i += r * r) {
                    sieve.set(i, false);
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int primeIndex = 0; primeIndex <= limit; primeIndex++) {
            if (sieve.get(primeIndex)) {
                primes.add(primeIndex);
            }
        }
        return primes;
    }

    public static void printSieves(int n, ArrayList<Integer> primes, String algorithmName) {
        System.out.println("Sieve of " + algorithmName);
        System.out.println("n = " + n);
        System.out.println(primes.toString());
    }

    public static void main(String[] args) {
        int n = 100;

        ArrayList<Integer> primes = sieveOfEratosthenes(n);
        printSieves(n, primes, "Eratosthenes");

        primes.clear();
        primes = sieveOfAtkin(n);
        printSieves(n, primes, "Atkin");
    }
}
