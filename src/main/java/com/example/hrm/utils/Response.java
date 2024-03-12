package com.example.hrm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private  long count;
    private T data;
    private String message;
    private int status;

    public Response(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }
}
