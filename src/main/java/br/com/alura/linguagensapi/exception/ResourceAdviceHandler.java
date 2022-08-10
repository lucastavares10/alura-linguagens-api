package br.com.alura.linguagensapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceAdviceHandler {

  @ResponseBody
  @ExceptionHandler(ResourceExceptionNotFound.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String handleResourceNotFound(ResourceExceptionNotFound ex) {
    return ex.getMessage();
  }

}
