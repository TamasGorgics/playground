# syntax = docker/dockerfile:1-experimental

FROM golang:1.18-alpine as builder


RUN apk --no-cache add git gcc musl-dev make

WORKDIR /app
COPY ./main.go ./app/main.go

ENV GO111MODULE=on

RUN export GOARCH=amd64 && export GOOS=linux && go build ./app/main.go

# Run container
FROM python:3.9-alpine

WORKDIR /app

COPY --from=builder /app/ ./
COPY requirements.txt /app/requirements.txt
COPY test.py /app/test.py
RUN pip install -r /app/requirements.txt

ENTRYPOINT ["./main"]