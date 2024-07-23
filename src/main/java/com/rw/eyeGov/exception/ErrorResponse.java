package com.rw.eyeGov.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@RequiredArgsConstructor
@Builder
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
public class ErrorResponse {

    private final String timestamp;
    private final Integer status;
    private final String code;
    private final String message;
    private final String path;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ErrorResponseBuilder {
    }
}