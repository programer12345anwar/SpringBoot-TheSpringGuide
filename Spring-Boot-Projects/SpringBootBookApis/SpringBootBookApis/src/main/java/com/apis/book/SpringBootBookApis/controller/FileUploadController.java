package com.apis.book.SpringBootBookApis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

@RestController
public class FileUploadController {

    
    @SuppressWarnings("null")
    @PostMapping("/upload-file") 
    public ResponseEntity<String> uploadFile(@PathVariable("file") MultipartFile file) {

        // System.out.println(file.getName());
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize()); 
        // System.out.println(file.getContentType());
        // System.out.println("File uploaded successfully");//will printed in console


        if(file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        //restict file upload type
        if(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File type is not allowed,please upload jpeg or pdf file");
        }
        System.out.println(file.getContentType());
        System.out.println("File uploaded successfully");
        return ResponseEntity.ok("File uploaded successfully");
    }
    
}
