package collegemanagement.global_exception;


import collegemanagement.customexceptions.IdNotFoundException;
import collegemanagement.customexceptions.NoSuchCombinationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

@ControllerAdvice
    public class MyControllerAdvice {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElement(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StringWriter stringWriter = new StringWriter();
        var printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stack = stringWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(status, "there is no element with id", stack), status);
    }


    @ExceptionHandler(NoSuchCombinationException.class)
    public ResponseEntity<ErrorResponse> handle() {
        var status = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                new ErrorResponse("Please check the details given!"), status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArguments(Exception e) {
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(Exception e) {
        var status = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                new ErrorResponse(status, e.getMessage()), status);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNumFormat(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 404

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(status,"Id not found!"), status);
    }
}




