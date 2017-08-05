This is a simple solution for the producer-consumer problem: https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem

This solution uses BlockingQueue to prevent deadlocks, but this way the threads are not aware of each other so the weakness of this solution is that when the producer finishes producing the consumer still tries to consume in an endless loop. 
