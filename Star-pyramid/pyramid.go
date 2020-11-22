package main

import (
	"fmt"
	"os"
	"strconv"
	s "strings"
)

func pyramid(n int) {
	for i := 1; i <= n; i++ {
		fmt.Println(s.Join([]string{s.Repeat(" ", n-i), s.Repeat("* ", i)}, ""))
	}
}

func main() {
	if len(os.Args) < 2 {
		panic("No level has been provided!")
	}

	n, err := strconv.Atoi(os.Args[1])

	if err != nil {
		panic("You need to provide an integer as level!")
	}

	pyramid(int(n))
}
