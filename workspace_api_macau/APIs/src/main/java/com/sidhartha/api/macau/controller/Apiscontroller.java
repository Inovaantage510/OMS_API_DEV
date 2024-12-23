package com.sidhartha.api.macau.controller;

import com.sidhartha.api.macau.entity.Testing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/rms")
public class Apiscontroller {

    @PostMapping(value = "/rmsapi/outage/notifyoutage", consumes = "application/json")
    public ResponseEntity<Object> v1(@RequestBody Testing modeRequest) {
        
        System.out.println("Received dateTime: " + modeRequest.getDateTime()); 
        
        if (modeRequest.getDateTime() == null || modeRequest.getDateTime().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: dateTime is missing or invalid");
        }

        try {
          
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

          
            LocalDateTime now = LocalDateTime.now();
            
           
            LocalDateTime providedDateTime = LocalDateTime.parse(modeRequest.getDateTime(), formatter);

           
            System.out.println("Parsed dateTime: " + providedDateTime);

          
            String status = "active"; 
            if (providedDateTime.isAfter(now)) {
                status = "deactive"; 
            }

            modeRequest.setStatus(status);

          
            ResponseFormat responseFormat = new ResponseFormat(true, true, null, 0);  
         
            
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseFormat);
        } catch (Exception e) {
           
            System.err.println("Error during dateTime parsing: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: Invalid dateTime format. Please use yyyyMMddHHmmss.");
        }
    }

    public static class ResponseFormat {
        private boolean success;
        private boolean data;
        private String error;
        private int dataCount;

        public ResponseFormat(boolean success, boolean data, String error, int dataCount) {
            this.success = success;
            this.data = data;
            this.error = error;
            this.dataCount = dataCount;
        }

       
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public boolean isData() {
            return data;
        }

        public void setData(boolean data) {
            this.data = data;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getDataCount() {
            return dataCount;
        }

        public void setDataCount(int dataCount) {
            this.dataCount = dataCount;
        }
    }
}