package com.rbtech.job.machines;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.rbtech.bhc008.data.Job;
import com.rbtech.bhc008.data.MessageLog;
import com.rbtech.job.tools.FileTools;

public class JobProcessor {

	// TODO use the values from Globals object instead
	private static final int MAX_SIZE_FTP           = 52428800;                 // 52428800 = 50.0MB  
	private static final int MAX_SIZE_EMAIL         = 20971520;                 // 20971520 = 20.0MB  
 	private static final int MAX_SIZE_PRINT         = 100000;                   //   100000 =  0.1MB
  	private static final int MAX_SIZE_PRINT_RTF     = 7500000; 
  	private static final String PROCESSED_EXTENSION = ".comp";
  			
	public boolean processJobs(ArrayList<Job> jobs) {

		for(int i = 0; i<jobs.size(); i++) {

		    if (jobs.get(i).isCurrent()) {
		    	MessageLog.logNewMessage("Processing job: " + jobs.get(i).getModuleName(), MessageLog.LOG_TYPE_INFO);  
						
				File folder = new File("C:\\SQL_Zone\\BHBs");
		    	// File folder = new File(jobs.get(i).getSourceDirectory()));
							
				FilenameFilter filterSelection = new FileListFilter(jobs.get(i).getModuleName()
						                                           ,jobs.get(i).getSourceFileExtension() );
				
			    File[] listOfFiles = folder.listFiles(filterSelection);
			
				for (File file : listOfFiles) {
				    if (file.isFile()) { 	
				    	MessageLog.logNewMessage(file.getName(), MessageLog.LOG_TYPE_INFO);
				    	MessageLog.logNewMessage(MessageLog.DOUBLE_UNDER, MessageLog.LOG_TYPE_FORMAT);
				      
				    		if (FileTools.isModifiedSince(file, FileTools.lastRunDate())) {
						 		processFile(jobs.get(i), file);
						 	  }
				    }
				} //filesloop
				
			} //end if (current job)
		    else {
				MessageLog.logNewMessage("Job: " + jobs.get(i).getModuleName() + " is not a current job.", MessageLog.LOG_TYPE_INFO);
			}	
		    MessageLog.logNewMessage(MessageLog.UNDER_SCORE, MessageLog.LOG_TYPE_FORMAT);
		} //jobsloop	 
		return true;   
			
		} //processJobs 

	class FileListFilter implements FilenameFilter {
		  private String name; 

		  private String extension; 

		  public FileListFilter(String name, String extension) {
		    this.name = name;
		    this.extension = extension;
		  }
	
		  public boolean accept(File directory, String filename) {
		    boolean fileOK = true;

		    if (name != null) {
		      fileOK &= filename.startsWith(name);
		    }

		    if (extension != null) {
		      fileOK &= filename.endsWith('.' + extension);
		    }
		    return fileOK;
		  }
	}
	
	private String processFile(Job job, File file) {
		
		String messageString="";
		String oldFileName;
		String newFileName;
		String remoteLocation;
		
		File folder = new File("C:\\SQL_Zone\\BHBs");
		
		FileTools fT = new FileTools();
				
		   if (file.length() <= MAX_SIZE_FTP && job.isToFtp() ) {
			  MessageLog.logNewMessage("FTP Process Started", MessageLog.LOG_TYPE_INFO);
		      
		   // remoteLocation = "/spp/spool/" + globals.getOracleSid() + "/data";
		      remoteLocation = "/spp/spool/RBTEST/data"; 
		      
		      messageString=fT.ftpPutFile("first", "bodger6", remoteLocation, file);
           // TODO
		   // emailNotification(toEmailAddress, ccEmailAddress, Message, Subject);
		   // logActions(message);
		   }	
		   
		   if (file.length() <= MAX_SIZE_EMAIL && job.isToEmail() ) {
			  System.out.println("Emailing file as attachment will happen here.");

		   // TODO
		   // email file as attachment
		   // emailNotification(toEmailAddress, ccEmailAddress, Message, Subject);
		   // logActions(message);
		   }
		   
	       if (file.length() < MAX_SIZE_PRINT && job.isToPrint() ) {
        	  System.out.println("Printing file will happen here.");
        	
           // TODO  
	       // print file (or head and tail)
		   // email notification
		   // logActions(message);
	       }
	       // TODO   
		   // rename file .comp
			oldFileName = file.getName();
			
	//		oldFileName = "test.txt";
			newFileName = oldFileName + PROCESSED_EXTENSION;
			
			//Method one
     		/*
     		 * 
     		File target = new File(newFileName);
     		
			try {
				Files.copy(file.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			
			//Method two
	//		File newFile = new File(file.getParent(), newFileName);
		    File newFile = new File(folder, newFileName );	
						
			MessageLog.logNewMessage(newFileName, "DEBUG");
			
			if(file.renameTo(newFile)){
				MessageLog.logNewMessage("File renamed from: " + oldFileName + " to " + newFileName, MessageLog.LOG_TYPE_INFO);
		    }else{
		       	MessageLog.logNewMessage("File: " + oldFileName + " could NOT be renamed to " + newFileName, MessageLog.LOG_TYPE_ERROR);
		    }

		return messageString;
		
	} //processFile
	
} //class	
