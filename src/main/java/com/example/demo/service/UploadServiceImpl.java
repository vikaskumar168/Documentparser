package com.example.demo.service;

import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.GenericResponse;

@Service
public class UploadServiceImpl {

    public GenericResponse uploadFile(MultipartFile file) {
       try(PDDocument document = Loader.loadPDF(file.getBytes())) {
                // Process the PDF document as needed
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);
                System.out.println("Extracted Text: " + text);
                GenericResponse response = new GenericResponse();
        response.setSuccess(true);
        return response;
       } catch (IOException e) {
              throw new RuntimeException("Failed to process PDF file", e);
       }

        
    }   
}