package com.codesnippet.ecomorderservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class MyCustomException extends  RuntimeException {
   private final HttpStatusCode statuesCode;
   private  final HttpHeaders headers;

    public MyCustomException(HttpStatusCode statuesCode, HttpHeaders headers) {
        this.statuesCode = statuesCode;
        this.headers = headers;
    }

    public HttpStatusCode getStatuesCode() {
        return statuesCode;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }
}
