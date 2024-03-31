package com.tenth.Shopping.Error;

public class ErrorMessageQuantity {
    private String description;
    public ErrorMessageQuantity(String message) {
        this.description = message;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
