package com.apis.book.SpringBootBookApis.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    public final String UPLOAD_DIRECTORY = "C:\\Users\\MD ANWAR ALAM\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Spring-Learning-Project\\Spring-Boot-Projects\\SpringBootBookApis\\SpringBootBookApis\\src\\main\\resources\\static";
    // For Linux, use "/" instead of "\\".

    public boolean upLoadFile(MultipartFile multipartFile) {
        boolean isUploaded = false;
        try {
            // Ensure directory exists
            File directory = new File(UPLOAD_DIRECTORY);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Copy file to the directory
            Files.copy(
                multipartFile.getInputStream(),
                Paths.get(UPLOAD_DIRECTORY + File.separator + multipartFile.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );

            isUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}
