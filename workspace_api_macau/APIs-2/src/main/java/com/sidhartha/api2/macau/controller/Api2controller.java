package com.sidhartha.api2.macau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidhartha.api2.macau.entity.Apisentity;
import com.sidhartha.api2.macau.entity.OutagePT;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@RestController
@RequestMapping("/apis")
public class Api2controller {

    @GetMapping("/v1")
    public ResponseEntity<Apisentity> v1() {

    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        Date now = new Date();

        String formattedDate = dateFormat.format(now);

    
    	 Apisentity entity = new Apisentity();
         entity.setDateTime(formattedDate);
         entity.setMode("tst");
     
        OutagePT outage1 = new OutagePT();
        outage1.setMv(outage1.getMv());
        outage1.setMvCurrentStatusDesc(outage1.getMvCurrentStatusDesc());
        outage1.setMvPlanningOutageBeginTime(null);
        outage1.setMvOutageBeginTime("2021-07-23 09:32:50");
        outage1.setMvEnergizedTime(null);
        outage1.setLv("KK130612");
        outage1.setLvSupplyPtCurrentStatusDesc("Actual Outage");
        outage1.setLvSupplyPtPlanningOutageBeginTime(null);
        outage1.setLvSupplyPtOutageBeginTime("2021-07-23 09:32:50");
        outage1.setLvSupplyPtEnergizedTime(null);

        OutagePT outage2 = new OutagePT();
        outage2.setMv("PT2124");
        outage2.setMvCurrentStatusDesc("Actual Outage");
        outage2.setMvPlanningOutageBeginTime(null);
        outage2.setMvOutageBeginTime("2021-07-23 09:32:50");
        outage2.setMvEnergizedTime(null);
        outage2.setLv("PH10089");
        outage2.setLvSupplyPtCurrentStatusDesc("Actual Outage");
        outage2.setLvSupplyPtPlanningOutageBeginTime(null);
        outage2.setLvSupplyPtOutageBeginTime("2021-07-23 09:32:50");
        outage2.setLvSupplyPtEnergizedTime(null);

        entity.setOutagePT(Arrays.asList(outage1, outage2)); 

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(entity);
    }
}