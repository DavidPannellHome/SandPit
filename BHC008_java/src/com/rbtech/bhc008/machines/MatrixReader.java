package com.rbtech.bhc008.machines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.rbtech.bhc008.data.Job;
import com.rbtech.bhc008.data.MessageLog;

public class MatrixReader {

	private ArrayList<Job> jobList;
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
	
	public ArrayList<Job> createJobList(File jobsFile) {
		populateJobList(jobsFile);
		return jobList;
		
	}
	
	private void populateJobList(File csvFile) {
		
		jobList = new ArrayList<Job>();
		
		// read jobs from a CSV file
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	    int lineNumber = 0;
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			 
			line = br.readLine(); //first line
			line = null;
			
			while ((line = br.readLine()) != null) {
	            lineNumber ++;
	            //System.out.println(lineNumber);
	            
			     // use comma as separator to get all data for Job
				String[] jobData = line.split(cvsSplitBy);
				// create new Job and populate with the data
				Job job = new Job();		
			    job.setCurrent(jobData[0].equalsIgnoreCase("y"));
				job.setModuleName(jobData[1]);
				job.setModuleDescription(jobData[2]);
			    job.setToFtp(jobData[3].equalsIgnoreCase("y"));
				job.setFtpDestination(jobData[4]);
				job.setFtpServer(jobData[5]);
				job.setToEmail(jobData[6].equalsIgnoreCase("y"));
				job.setEmailList(jobData[7]);
		//		job.setSourceServer(jobData[8]);
				job.setSourceDirectory(jobData[8]);
				job.setSourceFileExtension(jobData[9]);
				job.setToPrint(jobData[10].equalsIgnoreCase("y"));
				job.setPrinterName(jobData[11]);
				job.setPrintHeadOrTail(jobData[12]);
				job.setNumberOfLinesToPrint(Integer.parseInt((jobData[13]).replace("", "0")));
				job.setToReprocess(jobData[14].equalsIgnoreCase("y"));
	/*			try {
					job.setProcessFromDate(format.parse(jobData[15]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					job.setProcessToDate(format.parse(jobData[16]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	*/				
				jobList.add(job);
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		MessageLog.logNewMessage("Done reading matrix, " + lineNumber + " lines read.", MessageLog.LOG_TYPE_INFO);
		MessageLog.logNewMessage(MessageLog.UNDER_SCORE, MessageLog.LOG_TYPE_FORMAT);
	}
	
}
