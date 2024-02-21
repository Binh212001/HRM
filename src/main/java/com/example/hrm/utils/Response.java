package com.example.hrm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private T data;
    private String message;
    private int status;

}
