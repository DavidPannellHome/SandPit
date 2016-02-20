package com.rbtech.job;

import java.io.File;
import java.util.ArrayList;

import com.rbtech.bhc008.data.Job;
import com.rbtech.bhc008.data.MessageLog;
import com.rbtech.job.machines.JobProcessor;
import com.rbtech.job.machines.MatrixReader;
import com.rbtech.job.machines.PreProcessor;

public class Main {

	private static final String DEFAULT_JOBS_FILE_NAME = "S:\\Customer Services\\Oracle Reports\\Sys Admin\\BHC008_report_matrix.csv";

	public static void main(String[] args) {
    
		MessageLog.logNewMessage("Program Started", MessageLog.LOG_TYPE_INFO);
		
		PreProcessor preproc = new PreProcessor();
		//use this method when Java program is running in UNIX environment
		//preproc.setOracleSID();
		
		MatrixReader reader = new MatrixReader();
		
		
		
		
	    ArrayList<Job> jobs = reader.createJobList(getFile(args));
		
		JobProcessor processor = new JobProcessor();
		boolean success = processor.processJobs(jobs);
		MessageLog.logNewMessage("Jobs processed successfully? " + success, MessageLog.LOG_TYPE_INFO);
		
		//PostProcessor postproc = new PostProcessor;
		System.out.println(MessageLog.outputAllMessages());
	}

	private static File getFile(String [] args) {
		
		
		
		
		return new File(DEFAULT_JOBS_FILE_NAME);
	}

	
	
	
}
