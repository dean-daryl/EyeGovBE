package com.rw.eyeGov.dto;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (clientHttpResponse.getStatusCode().is4xxClientError()
                || clientHttpResponse.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode() != HttpStatus.CONFLICT
                && clientHttpResponse.getStatusCode() != HttpStatus.INTERNAL_SERVER_ERROR) {
            throw new IOException(clientHttpResponse.getStatusText());
        }

    }
}
