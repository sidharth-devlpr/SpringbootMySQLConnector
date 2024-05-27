package com.example.MySQLSpring;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd hh:mm:ss")
    private LocalDateTime localDateTime;
    private String message;

    public ErrorResponse(LocalDateTime localDateTime) {
        this.localDateTime = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status){
        this.localDateTime=LocalDateTime.now();
        this.status=status;
    }

    public ErrorResponse(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}
