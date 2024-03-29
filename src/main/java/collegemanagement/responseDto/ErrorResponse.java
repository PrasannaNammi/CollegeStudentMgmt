package collegemanagement.responseDto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
    @Getter
    @AllArgsConstructor(staticName = "build")
    public class ErrorResponse {
        // customizing timestamp serialization format
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private Date timestamp;

        private int code;

        private String status;

        private String message;

        private String stackTrace;

        private Object data;

        public ErrorResponse() {
            timestamp = new Date();
        }

        public ErrorResponse(HttpStatus httpStatus, String message) {
            this();

            this.code = httpStatus.value();
            this.status = httpStatus.name();
            this.message = message;
        }

        public ErrorResponse(String status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.stackTrace = stackTrace;
            this.data = data;
        }

        public ErrorResponse(Object data) {
            this.data = data;
        }

        public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace) {
            this(httpStatus, message);
            this.stackTrace = stackTrace;
        }

        public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace, Object data) {
            this(httpStatus, message, stackTrace);

            this.data = data;
        }

        public ErrorResponse(String  message) {

            this.message=message;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void setStatus(String status) {

            this.status = status;
        }

        public void setMessage(String message) {

            this.message = message;
        }

        public void setStackTrace(String stackTrace) {
            this.stackTrace = stackTrace;
        }

        public void setData(Object data) {
            this.data = data;
        }

    }


