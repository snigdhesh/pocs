package com.example.filedemo.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileDemoController {


    @RequestMapping(path = "/reference", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> download(String param) throws IOException {

        // method1: In this case file should be under root folder, which is same directory as pom.xml file
        File file1 = new File("demo.json");

        // method2: In this case file should be under resources folder, which is same directory as application.properties file.
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("demo.json").getFile());

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.json");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

    @RequestMapping(value = "/json")
    public ResponseEntity<InputStreamResource> downloadJSONFile()
            throws IOException {

        ClassPathResource file = new ClassPathResource("demo.json");
        getMimeType("demo.json");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.json");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    @RequestMapping("/text")
    public ResponseEntity<InputStreamResource> downloadTextFile()
            throws IOException {

        ClassPathResource pdfFile = new ClassPathResource("demo.txt");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.txt");

        getMimeType("demo.txt");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }


    @RequestMapping(value = "/pdf")
    public ResponseEntity<InputStreamResource> downloadPDFFile()
            throws IOException {

        ClassPathResource pdfFile = new ClassPathResource("demo.pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=demo.pdf");

        getMimeType("demo.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(pdfFile.getInputStream()));
    }

    public void getMimeType(String file) {
        File f = new File(file);
        System.out.println("Mime Type of " + f.getName() + " is " +
                new MimetypesFileTypeMap().getContentType(f));
    }
}
