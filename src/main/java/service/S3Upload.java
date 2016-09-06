package service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Upload {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/resources");
	private static AWSCredentials credentials = new BasicAWSCredentials(resourceBundle.getString("s3-id"), resourceBundle.getString("s3-key"));
	private static AmazonS3 s3client = new AmazonS3Client(credentials);
	private static final String SUFFIX = "/";
	
	public static String uploadFileToBucketPath(String localFilePath, String bucketName, String s3Path) {
		try {
			//建立S3 Bucket
			//s3client.createBucket(bucket);
			
			//建立Bucket內的資料夾
			for(int i = 1; i < s3Path.split("/").length; i++){
				if(s3Path.split("/")[i].lastIndexOf(".") < 0){
					createFolder(bucketName, s3Path.split("/")[i], s3client);
				}
			}
	        
			s3client.putObject(new PutObjectRequest(bucketName, s3Path, new File(localFilePath))
					.withCannedAcl(CannedAccessControlList.PublicRead));
			
			String returnMsg = isFileExistedInBucketPath(bucketName, s3Path, s3client);
			return returnMsg;
	    } catch (Exception e) {
	        return e.getMessage();
	    }
	}

	public static String isFileExistedInBucketPath(String bucket, String path, AmazonS3 client) {
	    GetObjectMetadataRequest request = new GetObjectMetadataRequest(bucket,path);
	    try {
	    	client.getObjectMetadata(request);
	        return "File Exist";
	    } catch (Exception e) {
	        return "File Not Exist";
	    }

	}
	
	public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + SUFFIX, emptyContent, metadata);
		client.putObject(putObjectRequest);
	}
	
	public static void deleteFolder(String bucketName, String folderName, AmazonS3 client) {
		List<S3ObjectSummary> fileList = client.listObjects(bucketName, folderName).getObjectSummaries();
		for (S3ObjectSummary file : fileList) {
			client.deleteObject(bucketName, file.getKey());
		}
		client.deleteObject(bucketName, folderName);
	}
}
