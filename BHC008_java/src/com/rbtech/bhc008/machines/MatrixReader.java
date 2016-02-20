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
import java.util.List;
import java.util.Locale;

import com.rbtech.bhc008.data.Job;
import com.rbtech.bhc008.data.MessageLog;

public class MatrixReader {

	enum Fields {

		PROCESS_INDICATOR(14),
		NUMBER_OF_LINES_TO_PRINT(13),
		HEADER_TAIL(12), 
		PRINTER_NAME(11), 
		TO_PRINT_INDICATOR(10),
		SOURCE_FILE_EXTENSION(9),
		SOURCE_DIRECTORY(8),
		EMAIL_LIST(7),
		EMAIL_INDICATOR(6),
		FTP_SERVER(5), FTP_DESTINATION(4),
		FTP_INDICATOR(3), 
		MODULE_DESCRIPTION(2),
		MODULE_NAME(1),
		CURRENT(0);

		public int column;

		Fields(int pos) {
			column = pos;
		}

	}

	static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

	private ArrayList<Job> jobList;

	// use comma as separator to get all data for Job
	static final String CSV_SPLIT_BY = ",";

	public ArrayList<Job> createJobList(File jobsFile) {
		jobList = new ArrayList<Job>();
		try {
			doPopulateJobListFromFile(jobsFile, jobList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MessageLog.logNewMessage(MessageLog.UNDER_SCORE, MessageLog.LOG_TYPE_FORMAT);
		return jobList;

	}



	// read jobs from a CSV file
	private void doPopulateJobListFromFile(File csvFile, List<Job> jobs) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		try {
			readJobsFromReader(jobs, br);
		} finally {
			br.close();
		}
	}

	
	
	private void readJobsFromReader(List<Job> jobs, BufferedReader br) {
		int lineCount = 0;
		try {
			String line = br.readLine(); // first line (header line?)
			while ((line = br.readLine()) != null) {
				lineCount++;
				Job job = createJobFromCsvLine(line);
				jobs.add(job);
			}
			MessageLog.logNewMessage("Done reading matrix, " + lineCount + " lines read.", MessageLog.LOG_TYPE_INFO);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	private Job createJobFromCsvLine(String line) {
		// create new Job and populate with the data
		Job job = new Job();
		String[] jobData = line.split(CSV_SPLIT_BY);
		job.setCurrent(jobData[Fields.CURRENT.column].equalsIgnoreCase("y"));
		job.setModuleName(jobData[Fields.MODULE_NAME.column]);
		job.setModuleDescription(jobData[Fields.MODULE_DESCRIPTION.column]);
		job.setToFtp(jobData[Fields.FTP_INDICATOR.column].equalsIgnoreCase("y"));
		job.setFtpDestination(jobData[Fields.FTP_DESTINATION.column]);
		job.setFtpServer(jobData[Fields.FTP_SERVER.column]);
		job.setToEmail(jobData[Fields.EMAIL_INDICATOR.column].equalsIgnoreCase("y"));
		job.setEmailList(jobData[Fields.EMAIL_LIST.column]);
		job.setSourceDirectory(jobData[Fields.SOURCE_DIRECTORY.column]);
		job.setSourceFileExtension(jobData[Fields.SOURCE_FILE_EXTENSION.column]);
		job.setToPrint(jobData[Fields.TO_PRINT_INDICATOR.column].equalsIgnoreCase("y"));
		job.setPrinterName(jobData[Fields.PRINTER_NAME.column]);
		job.setPrintHeadOrTail(jobData[Fields.HEADER_TAIL.column]);
		job.setNumberOfLinesToPrint(Integer.parseInt((jobData[Fields.NUMBER_OF_LINES_TO_PRINT.column]).replace("", "0")));
		job.setToReprocess(jobData[Fields.PROCESS_INDICATOR.column].equalsIgnoreCase("y"));
		return job;
	}

}
