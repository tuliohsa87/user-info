package io.github.tuliohsa87.userinfo.exceptions;

import io.github.tuliohsa87.userinfo.exceptions.exception.CpfException;
import io.github.tuliohsa87.userinfo.exceptions.model.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(CpfException.class)
    public ResponseEntity<StandardError> emailNotSent(CpfException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(NOT_FOUND.value());
        err.setError("Not Found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(NOT_FOUND).body(err);
    }
}
