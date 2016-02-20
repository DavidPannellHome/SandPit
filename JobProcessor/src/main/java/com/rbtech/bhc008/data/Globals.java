package com.rbtech.bhc008.data;

import com.rbtech.job.tools.UnixTools;

public class Globals {

	public static final int    MAX_SIZE_FTP = 52428800;                           // 52428800 = 50.0MB  
	public static final int    MAX_SIZE_EMAIL = 20971520;                         // 20971520 = 20.0MB  
	public static final int    MAX_SIZE_PRINT = 100000;                           //   100000 =  0.1MB
	public static final int    MAX_SIZE_PRINT_RTF = 7500000; 
	public static final String RBTECH_EMAIL = "rbtech@brighton-hove.gov.uk";
	
    private String oracleSID;
    
    public Globals() {
    //Constructor without a string value, get Oracle SID via UNIX command
    	setOracleSID();
    }
    
    public Globals(String oracleSID) {
    //Constructor with a string value, use this to set Oracle SID	
    	setOracleSID(oracleSID);
    }
    
	public String getOracleSID() {
		return oracleSID;
	}

	public void setOracleSID() {	
		UnixTools ut = new UnixTools();
		this.oracleSID = ut.RunCommand("echo ORACLE_SID");
	}
	
	public void setOracleSID(String oracleSID) {
		this.oracleSID = oracleSID;
	}
	
}
