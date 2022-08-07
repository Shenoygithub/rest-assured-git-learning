package restassured.model;

public class FileAPI {


	 private String fileId;
     private String fileType;
     private String message;
     private String downloadUri; 
     private String uploadStatus;
	
     public FileAPI() {}

	public FileAPI(String fileId, String fileType, String message, String downloadUri, String uploadStatus) {
		super();
		this.fileId = fileId;
		this.fileType = fileType;
		this.message = message;
		this.downloadUri = downloadUri;
		this.uploadStatus = uploadStatus;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDownloadUri() {
		return downloadUri;
	}

	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}

	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
     
     
	
}
