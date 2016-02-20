package com.rbtech.bhc008;

import java.io.File;
import java.util.ArrayList;

import com.rbtech.bhc008.data.Job;
import com.rbtech.bhc008.data.MessageLog;
import com.rbtech.bhc008.machines.PreProcessor;
import com.rbtech.bhc008.machines.JobProcessor;
import com.rbtech.bhc008.machines.MatrixReader;

public class Main {

	public static void main(String[] args) {
    
		MessageLog.logNewMessage("Program Started", MessageLog.LOG_TYPE_INFO);
		
		PreProcessor preproc = new PreProcessor();
		//use this method when Java program is running in UNIX environment
		//preproc.setOracleSID();
		
		MatrixReader reader = new MatrixReader();
	    ArrayList<Job> jobs = reader.createJobList(new File("S:\\Customer Services\\Oracle Reports\\Sys Admin\\BHC008_report_matrix.csv"));
		
		JobProcessor processor = new JobProcessor();
		boolean success = processor.processJobs(jobs);
		MessageLog.logNewMessage("Jobs processed successfully? " + success, MessageLog.LOG_TYPE_INFO);
		
		//PostProcessor postproc = new PostProcessor;
		System.out.println(MessageLog.outputAllMessages());
	}

}
