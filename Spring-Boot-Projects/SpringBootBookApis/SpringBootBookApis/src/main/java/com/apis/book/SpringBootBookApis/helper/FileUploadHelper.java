package com.apis.book.SpringBootBookApis.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    public final String UPLOAD_DIRECTORY = "C:\\Users\\MD ANWAR ALAM\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Spring-Learning-Project\\Spring-Boot-Projects\\SpringBootBookApis\\SpringBootBookApis\\src\\main\\resources\\static";//we need to make it dynamic to store in static folder of any system
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
            //This allows reading the file's contents.=>multipartFile.getInputStream()
            /*Paths.get(UPLOAD_DIRECTORY + File.separator + multipartFile.getOriginalFilename()):

Constructs the full path to the target file where the uploaded file will be saved.
UPLOAD_DIRECTORY: Base directory where files should be saved.
File.separator: Ensures the correct path separator is used (/ or \ depending on the OS).
multipartFile.getOriginalFilename(): Retrieves the original name of the uploaded file. For example, if a user uploads a file named document.pdf, this ensures the file is saved as document.pdf.
Files.copy():

Copies the file's contents from the InputStream (source) to the target location (destination).
Parameters:
Source: multipartFile.getInputStream() (reads the uploaded file).
Destination: Paths.get(...) (the full path to save the file).
StandardCopyOption.REPLACE_EXISTING: If a file with the same name already exists, it will be replaced. */
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
