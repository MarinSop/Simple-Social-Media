package com.marinsop.sc.components;

import com.marinsop.sc.exceptions.*;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(UserAlreadyExistsException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(BadCredentialsException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = AccountStatusException.class)
    @ResponseStatus(HttpStatus.LOCKED)
    public @ResponseBody ErrorResponse handleException(AccountStatusException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.LOCKED.value());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse handleException(AccessDeniedException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(value = SignatureException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse handleException(SignatureException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse handleException(ExpiredJwtException ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(value = UserNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(UserNotFound ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
    }
    @ExceptionHandler(value = FriendshipAlreadyExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(FriendshipAlreadyExists ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = FriendshipNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(FriendshipNotFound ex) {
        return new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
    }
}
