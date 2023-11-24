package edu.ufape.mensageiro.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.ufape.mensageiro.negocio.cadastro.RegistroDuplicadoException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    Map<String, Map<String,String>> ret = new HashMap<>();
	    ret.put("errors", errors);
		return new ResponseEntity<>(ret, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RegistroDuplicadoException.class)
	protected ResponseEntity<Object> handleRegistroDuplicadoException(RegistroDuplicadoException ex) {
		 Map<String, String> error = new HashMap<>();
		 error.put("Error: ", ex.getMessage());
		 return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
