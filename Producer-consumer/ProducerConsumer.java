import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

public class ProducerConsumer {

	static BlockingQueue sharedQueue = new LinkedBlockingDeque<>();
	
	public static void main(String... args) {
		
		new Thread(() -> {
			IntStream.range(1, 11).forEach(i -> {
				try {
					sharedQueue.put(i);
					System.out.println(String.format("Producer produced: %d", i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}).start();
		
		new Thread(() -> {
			while(true) {
				try {
					System.out.println(String.format("Consumer consumed: %d", sharedQueue.take()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
