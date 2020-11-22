package main

import (
	"fmt"
	"time"
)

func main() {
	buf := make(chan int, 3)
	done := make(chan bool)

	// Producer
	go func() {
		for i := 1; i <= 10; i++ {
			fmt.Printf("Producer produced: %d\n", i)
			buf <- i
			time.Sleep(time.Second)
		}
		close(buf)
	}()

	// Consumer
	go func() {
		for i := range buf {
			fmt.Printf("Consumer consumed: %d\n", i)
			time.Sleep(time.Second * 2)
		}
		done <- true
	}()

	<-done
}
