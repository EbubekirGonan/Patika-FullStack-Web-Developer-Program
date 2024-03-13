package dev.patika.vet_management.core.config;

import dev.patika.vet_management.core.exception.InvalidVaccineException;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFound(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultWithData<List<String>>> methodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> validaitonErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(ResultHelper.validateError(validaitonErrorList), HttpStatus.BAD_REQUEST);
    }
/*
    @ExceptionHandler(InvalidVaccineException.class)
    public ResponseEntity<Result> invalidVaccineException (InvalidVaccineException e){
        return new ResponseEntity<>(ResultHelper.invalidVaccine(),HttpStatus.BAD_REQUEST);
    }
 */

}
