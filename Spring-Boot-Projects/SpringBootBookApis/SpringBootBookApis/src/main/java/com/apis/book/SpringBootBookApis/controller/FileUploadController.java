package com.apis.book.SpringBootBookApis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apis.book.SpringBootBookApis.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Validation: Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("File is empty. Please upload a valid file.");
            }

            // Check file content type
            String contentType = file.getContentType();
            /*JPEG images (.jpg, .jpeg with MIME type image/jpeg).
            PNG images (.png with MIME type image/png). */
            // if (contentType == null || 
            //     (!contentType.equals("image/jpeg") && !contentType.equals("image/png"))) {
            //     return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            //             .body("Invalid file type. Please upload a JPG or PNG file.");
            // }
            //=====================================================
            if (contentType == null || 
            (!contentType.equals("image/jpeg")  )) {
                //Here only .jpg and .jpeg files are allowed,.png files are not allowed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid file type. Please upload a image/jpg file. that means only .jpg and .jpeg files are allowed.");
        }
            //=====================================================

            /*!contentType.equals("image/jpg") && !contentType.equals("image/png")
            Purpose: Validates whether the file's MIME type matches either image/jpg (for JPG files) or image/png (for PNG files).

            contentType.equals("image/jpg") checks if the file is a JPG image.
            contentType.equals("image/png") checks if the file is a PNG image.
            The ! negation means "if it's not this type."
            Logical Operator &&:

            Combines the two conditions:
            The file is not a JPEG.
            The file is not a PNG.
            If both conditions are true (meaning the file is neither a JPG nor a PNG), the if block executes.  */

            // File upload logic
            boolean isUploaded = fileUploadHelper.upLoadFile(file);
            if (isUploaded) {
                // return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());

                return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            } else {
                System.out.println("Error uploading file. Something went wrong!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error uploading file. Something went wrong!");
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
