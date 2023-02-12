package kz.satbayev.medicalservices.payload;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final LocalDateTime dateTime;

    private final String message;

    public ErrorResponse(String message) {
        this.dateTime = LocalDateTime.now();
        this.message = message;
    }
}
