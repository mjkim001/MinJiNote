package kr.or.ddit.basic.fileUpload;

public class FileInfo {
	private String fileName;//파일명
	private long fileSize;	//파일크기
	private String status;	//upload 성공여부
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
