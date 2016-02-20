package com.rbtech.job.tools;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.rbtech.bhc008.data.MessageLog;

public class FileTools {


	public static Date lastRunDate() {
		// Dummy method for now until we retrieve the last bhc008 outputfile
		// need to ensure this is correct down to nearest second. ***
  		
	  	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date d1;
		
    	try {
    		d1 = df.parse("01-04-2015");
   		    return d1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Calendar cal = Calendar.getInstance();
			d1 = cal.getTime();

		}
    	
    	return d1;
    	
        }
	
	public static boolean isModifiedSince(File file, Date date) {
		// compares the last modified date of a file to supplied date
		// need to ensure this is correct down to nearest second. ***
   	
		
		if (file.lastModified() - date.getTime() > 0) {
			 MessageLog.logNewMessage("File created since " + date + " processing file...          ", MessageLog.LOG_TYPE_INFO);
        	 return true;
        }
        else {
        	 MessageLog.logNewMessage("File created before " + date + " SKIPPING this file.        ", MessageLog.LOG_TYPE_WARN);
        	 return false;     
        }
        	
	} // isModifiedSince
	
		public String ftpPutFile(String un, String pw, String remoteLocation, File f1) {

			int reply;
			String message = "";
			
			String host = "uap-iworld2";
			String username = un;
			String password = pw;

			FTPClient ftp = new FTPClient();

			try {
				ftp.connect(host);
				
				MessageLog.logNewMessage("Connected to " + host + ".", MessageLog.LOG_TYPE_INFO);
				MessageLog.logNewMessage("FTP reply: " + ftp.getReplyString(), MessageLog.LOG_TYPE_INFO);

			    // After connection attempt, you should check the reply code to verify success.
			    reply = ftp.getReplyCode();

			    if(!FTPReply.isPositiveCompletion(reply)) {
			      ftp.disconnect();
			      MessageLog.logNewMessage("FTP server refused connection.", MessageLog.LOG_TYPE_ERROR);
			      System.err.println("FTP server refused connection.");
			      
			      // Want to say specifically what the error was really
			      Exception e = new Exception();
			      throw e;
			    }		
				
				ftp.login(username, password);
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				ftp.changeWorkingDirectory(remoteLocation);
				FileInputStream in = new FileInputStream(f1);
				
				MessageLog.logNewMessage("About to put file: " + f1.getName(), MessageLog.LOG_TYPE_INFO);
				//ftp.storeFile(f1.getName(), in);
				MessageLog.logNewMessage("File put successful: " + f1.getName(), MessageLog.LOG_TYPE_INFO);
				
				// FileInputStream fis = null;
				ftp.logout();
				
			} catch (Exception e) {
				message += "File: " + f1.getName()
						+ " failed to upload to FTP server<br>";
				MessageLog.logNewMessage("Error in FTP process: " + e.getMessage(), MessageLog.LOG_TYPE_INFO);
				e.printStackTrace();
			}
			return message;

	} // ftpPutFile
}
