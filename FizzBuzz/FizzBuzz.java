import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(final String... args) {
        try {
            fizzBuzz(Integer.valueOf(args[0]).intValue());
        } catch (final NumberFormatException nfe) {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java FizzBuzz <number>");
    }

    private static void fizzBuzz(final int x) {
        IntStream.rangeClosed(1, x).forEach(i -> {
            var value = "";
            if (i % 3 == 0) {
                value += "Fizz";
            }
            if (i % 5 == 0) {
                value += "Buzz";
            }
            System.out.println(value.isEmpty() ? i : value);
        });
    }
}
