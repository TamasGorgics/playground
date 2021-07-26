import java.util.stream.IntStream;

public class FizzBuzzPrime {

    public static void main(final String... args) {
        try {
            fizzBuzzPrime(Integer.valueOf(args[0]).intValue());
        } catch (final NumberFormatException nfe) {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java FizzBuzzPrime <number>");
    }

    private static void fizzBuzzPrime(final int x) {
        IntStream.rangeClosed(1, x).forEach(i -> {
            var value = "";
            if (i % 3 == 0) {
                value += "Fizz";
            }
            if (i % 5 == 0) {
                value += "Buzz";
            }
            if (isPrime(i)) {
                value = "Bang";
            }
            System.out.println(value.isEmpty() ? i : value);
        });
    }

    private static boolean isPrime(final int x) {
        if (x == 1) {
            return false;
        }
        if (x == 2 || x == 3) {
            return true;
        }
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
