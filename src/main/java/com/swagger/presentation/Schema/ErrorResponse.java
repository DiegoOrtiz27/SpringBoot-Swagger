package com.swagger.presentation.Schema;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Error response details")
public class ErrorResponse {
    @Schema(description = "Error message", example = "Club not found")
    private String message;
    
    @Schema(description = "HTTP status code", example = "404")
    private String status;

    public ErrorResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
