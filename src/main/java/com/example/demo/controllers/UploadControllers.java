package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.GenericResponse;
import com.example.demo.service.UploadServiceImpl;

@RestController
@RequestMapping("/api/files")
public class UploadControllers {

    @Autowired
    private UploadServiceImpl uploadServiceImpl;

    @GetMapping("/")
    public String home() {
        return "Welcome to the File Upload Service";
    }

    @PostMapping("/upload")
    public GenericResponse uploadFile(@RequestParam("file") MultipartFile file) {

        uploadServiceImpl.uploadFile(file);
        GenericResponse response = new GenericResponse();
        response.setSuccess(true);
        return response;
    }   
}