package com.kinghotel.KingHotel.service;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kinghotel.KingHotel.exception.OurException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class AwsS3Service {

    private final String bucketName = "king-hotel-image";

    @Value("${aws.s3.access.key}")
    private String awsS3AccessKey;

    @Value("${aws.s3.secret.key}")
    private String awsS3SecretKey;

    public String saveImageToS3(MultipartFile photo) {
        String s3LocationImage = null;

        try {
            // Kiểm tra định dạng ảnh (có thể thay đổi theo yêu cầu)
            if (!photo.getContentType().startsWith("image/")) {
                throw new OurException("File is not an image.");
            }

            String s3Filename = photo.getOriginalFilename();

            // Cấu hình AWS credentials
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsS3AccessKey, awsS3SecretKey);
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(Regions.AP_SOUTHEAST_2) // Chỉnh lại khu vực cho đúng
                    .build();

            InputStream inputStream = photo.getInputStream();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(photo.getContentType()); // Sử dụng content type từ file

            // Tạo yêu cầu để upload tệp lên S3
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3Filename, inputStream, metadata);
            s3Client.putObject(putObjectRequest);

            // Trả về URL của ảnh sau khi upload
            return "https://" + bucketName + ".s3.amazonaws.com/" + s3Filename;

        } catch (Exception e) {
            // Log lỗi chi tiết và ném exception có thông điệp rõ ràng
            e.printStackTrace();
            throw new OurException("Unable to upload image to s3 bucket: " + e.getMessage());
        }
    }
}
