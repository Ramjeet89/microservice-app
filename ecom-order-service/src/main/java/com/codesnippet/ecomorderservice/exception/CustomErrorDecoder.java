package com.codesnippet.ecomorderservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new RuntimeException("Product Not Found");
        }
        return new RuntimeException("Genric Error: " + response.status());
    }
}
