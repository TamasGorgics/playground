package producer_consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ProducerConsumer3 {

    final static int bufferSize = 3;
    static List<Integer> buffer = new LinkedList<Integer>();

    public static void main(final String... args) {

        // Producer
        new Thread(() -> {
            IntStream.range(1, 11).forEach(i -> {
                synchronized (buffer) {
                    while (buffer.size() == bufferSize) {
                        System.out.println("Buffer is full, producer is waiting... Size: " + buffer.size());
                        try {
                            buffer.wait();
                        } catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(String.format("Producer produced: %d", i));
                    buffer.add(i);
                    buffer.notifyAll();
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 11));
                } catch (final Exception e) {
                    e.printStackTrace();
                }

            });
        }).start();

        //Consumer
        new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {

                        System.out.println("Buffer is empty, consumer is waiting... Size: " + buffer.size());
                        try {
                            buffer.wait();
                        } catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(String.format("Consumer consumed: %d", buffer.remove(0)));
                    buffer.notifyAll();
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 11));
                } catch (final Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
