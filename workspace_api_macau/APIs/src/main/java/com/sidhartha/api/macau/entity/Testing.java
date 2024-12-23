package com.sidhartha.api.macau.entity;

public class Testing {
	
    private String dateTime;  // Ensure this matches exactly with the incoming field name
    private String mode;
    private String status;

    // Default constructor
    public Testing() {
        super();
    }

    // Constructor to initialize the object
    public Testing(String dateTime, String mode, String status) {
        super();
        this.dateTime = dateTime;
        this.mode = mode;
        this.status = status;
    }

    // Getter and setter for dateTime
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    // Getter and setter for mode
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    // Getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}