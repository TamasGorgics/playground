import java.util.stream.IntStream;

public class Pyramid {

    public static void main(final String... args) {
        try {
            drawPyramid(Integer.valueOf(args[0]).intValue());
        } catch (final NumberFormatException nfe) {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java Pyramid <number of levels of the pyramid>");
    }

    private static void drawPyramid(final int levels) {
        IntStream.rangeClosed(1, levels).forEach(i -> {
            System.out.print(" ".repeat(levels - i));
            System.out.print("* ".repeat(i));
            System.out.println();
        });
    }
}
