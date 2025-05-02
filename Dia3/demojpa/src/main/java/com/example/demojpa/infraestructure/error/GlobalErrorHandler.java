package com.example.demojpa.infraestructure.error;


import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demojpa.infraestructure.error.model.FieldError;
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handlerRunTimeException(RuntimeException e){

        return ResponseEntity.badRequest().body(Map.of("error",e.getMessage(),"statusCode",HttpStatus.BAD_REQUEST.value()));
       
        /* 
        Map<String, Object> error = new HashMap<>();
        error.put("statusCode", 400);
        error.put("mesaage "," Ocurrio un error ");
        return error;
        */
    }

    @ExceptionHandler(RoldDuplicationException.class)
    public ResponseEntity<?> handlerRolDuplicateException(RoldDuplicationException e){

        return ResponseEntity.badRequest().
        body(
            Map.of(
                "error",e.getMessage(),
                "statusCode",e.getStatus().value()
            )
        );
      
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>handleFieldsException(MethodArgumentNotValidException e){
        List<FieldError> fieldError=e.getFieldErrors().stream()
            .map(field -> new FieldError(field.getField(),field.getDefaultMessage()))
            .toList();

            return ResponseEntity.badRequest().body(fieldError);
    }

}
