package com.marinsop.sc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int statusCode;
    public ErrorResponse(String msg)
    {
        super();
        message = msg;
    }
}
