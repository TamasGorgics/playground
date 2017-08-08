package producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumer2 {

    private static BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>();

    public static void main(final String... args) {
        final ExecutorService es = Executors.newFixedThreadPool(2);

        // Producer
        es.submit(() -> {
            IntStream.range(1, 11).forEach(i -> {
                System.out.println(String.format("Producer produced: %d", i));
                try {
                    buffer.put(i);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            });
        });

        // Consumer
        es.submit(() -> {
            while (true) {
                System.out.println(String.format("Consumer consumed: %d", buffer.take()));
            }
        });
    }
}
