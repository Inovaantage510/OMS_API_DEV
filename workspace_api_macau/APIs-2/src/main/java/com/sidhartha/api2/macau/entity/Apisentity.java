package com.sidhartha.api2.macau.entity;

import java.util.List;

public class Apisentity {

    private String dateTime;
    private String mode;
    private List<OutagePT> outagePT;
    private List<OutageAddr> outageAddr ;  

    public List<OutageAddr> getOutageAddr() {
		return outageAddr;
	}

	public void setOutageAddr(List<OutageAddr> outageAddr) {
		this.outageAddr = outageAddr;
	}

	public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<OutagePT> getOutagePT() {
        return outagePT;
    }

    public void setOutagePT(List<OutagePT> outagePT) {
        this.outagePT = outagePT;
    }
}