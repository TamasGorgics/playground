Invoke a python script from a go program living in the same container

```
docker build . -t python_and_go
docker run python_and_go
```

Expected output:
>stdout: 12
>Hello, World!
>
>stderr:
