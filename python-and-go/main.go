package main

import (
	"bytes"
	"fmt"
	"os/exec"
)

func main() {
	var args []string
	var stdout bytes.Buffer
	var stderr bytes.Buffer

	args = append(args, "test.py", "--param_1=1", "--param_2=2", "--message=Hello, World!")
	command := "python3"
	cmd := exec.Command(command, args...) // nolint: gosec
	cmd.Stdout = &stdout
	cmd.Stderr = &stderr
	err := cmd.Run()
	if err != nil {
		fmt.Println(fmt.Errorf("oops: %s", err.Error()))
	}

	fmt.Printf("stdout: %s \n", stdout.String())
	fmt.Printf("stderr: %s \n", stderr.String())
}
