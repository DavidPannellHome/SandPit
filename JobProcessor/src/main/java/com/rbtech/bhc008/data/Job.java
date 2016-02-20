package com.rbtech.bhc008.data;

import java.util.Date;

public class Job {

        private boolean    isCurrent;
		private String     moduleName;	
		private String     moduleDescription;	
		private boolean    isToFtp;
		private String     ftpDestination;
		private String     ftpServer;
		private boolean    isToEmail;
		private String     emailList;  
		private String     sourceServer;
		private String     sourceDirectory;
		private String     sourceFileExtension;
		private boolean    isToPrint;
		private String     printerName;
		private String     printHeadOrTail;
		private int        numberOfLinesToPrint;
		private boolean    isToReprocess;
		private Date       processFromDate;
		private Date       processToDate;
		
		public boolean isCurrent() {
			return isCurrent;
		}
		public void setCurrent(boolean isCurrent) {
			this.isCurrent = isCurrent;
		}
		public String getModuleName() {
			return moduleName;
		}
		public void setModuleName(String moduleName) {
			this.moduleName = moduleName;
		}
		public String getModuleDescription() {
			return moduleDescription;
		}
		public void setModuleDescription(String moduleDescription) {
			this.moduleDescription = moduleDescription;
		}
		public boolean isToFtp() {
			return isToFtp;
		}
		public void setToFtp(boolean isToFtp) {
			this.isToFtp = isToFtp;
		}
		public String getFtpDestination() {
			return ftpDestination;
		}
		public void setFtpDestination(String ftpDestination) {
			this.ftpDestination = ftpDestination;
		}
		public String getFtpServer() {
			return ftpServer;
		}
		public void setFtpServer(String ftpServer) {
			this.ftpServer = ftpServer;
		}
		public boolean isToEmail() {
			return isToEmail;
		}
		public void setToEmail(boolean isToEmail) {
			this.isToEmail = isToEmail;
		}
		public String getEmailList() {
			return emailList;
		}
		public void setEmailList(String emailList) {
			this.emailList = emailList;
		}
		public String getSourceServer() {
			return sourceServer;
		}
		public void setSourceServer(String sourceServer) {
			this.sourceServer = sourceServer;
		}
		public String getSourceDirectory() {
			return sourceDirectory;
		}
		public void setSourceDirectory(String sourceDirectory) {
			this.sourceDirectory = sourceDirectory;
		}
		public String getSourceFileExtension() {
			return sourceFileExtension;
		}
		public void setSourceFileExtension(String sourceFileExtension) {
			this.sourceFileExtension = sourceFileExtension;
		}
		public boolean isToPrint() {
			return isToPrint;
		}
		public void setToPrint(boolean isToPrint) {
			this.isToPrint = isToPrint;
		}
		public String getPrinterName() {
			return printerName;
		}
		public void setPrinterName(String printerName) {
			this.printerName = printerName;
		}
		public String getPrintHeadOrTail() {
			return printHeadOrTail;
		}
		public void setPrintHeadOrTail(String printHeadOrTail) {
			this.printHeadOrTail = printHeadOrTail;
		}
		public int getNumberOfLinesToPrint() {
			return numberOfLinesToPrint;
		}
		public void setNumberOfLinesToPrint(int numberOfLinesToPrint) {
			this.numberOfLinesToPrint = numberOfLinesToPrint;
		}
		public boolean isToReprocess() {
			return isToReprocess;
		}
		public void setToReprocess(boolean isToReprocess) {
			this.isToReprocess = isToReprocess;
		}
		public Date getProcessFromDate() {
			return processFromDate;
		}
		public void setProcessFromDate(Date processFromDate) {
			this.processFromDate = processFromDate;
		}
		public Date getProcessToDate() {
			return processToDate;
		}
		public void setProcessToDate(Date processToDate) {
			this.processToDate = processToDate;
		}




}