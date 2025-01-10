package com.apis.book.SpringBootBookApis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apis.book.SpringBootBookApis.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @SuppressWarnings("null")
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Validation: Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

            // Restrict file upload type
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("File type is not allowed, please upload a JPEG or PNG file");
            }

            System.out.println("File Content Type: " + file.getContentType());

            // File upload code
            boolean isUploaded = fileUploadHelper.upLoadFile(file);
            if (isUploaded) {
                return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error uploading file, something went wrong!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception occurred while uploading file: " + e.getMessage());
        }
    }
}

/* 
package com.apis.book.SpringBootBookApis.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apis.book.SpringBootBookApis.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    
    @SuppressWarnings("null")
    @PostMapping("/upload-file") 
    public ResponseEntity<String> uploadFile(@PathVariable("file") MultipartFile file) {

        // System.out.println(file.getName());
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize()); 
        // System.out.println(file.getContentType());
        // System.out.println("File uploaded successfully");//will printed in console

        try{

        
        //validation
        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        //restict file upload type
        if(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File type is not allowed,please upload jpeg or pdf file");
        }
        System.out.println(file.getContentType());
        System.out.println("File uploaded successfully");

        //file upload code
        boolean isUploaded = fileUploadHelper.upLoadFile(file);
        if(isUploaded) {
            System.out.println("File uploaded successfully");
            return ResponseEntity.ok("File uploaded successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file,something went wrong!");

    }catch(Exception e) {
        e.printStackTrace();
    }
        //requirement:where to upload the file on server :UPLOAD_DIR=C:/temp

        return ResponseEntity.ok("File uploaded successfully");
    }
    
}
*/
