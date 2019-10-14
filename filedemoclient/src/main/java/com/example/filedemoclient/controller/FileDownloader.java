package com.example.filedemoclient.controller;

import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileDownloader {

    String baseURL = "http://localhost:8080/text";


    @RequestMapping("/download")
    public String downloadFile() throws IOException {
        List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
        httpMessageConverters.add(new ByteArrayHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate(httpMessageConverters);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<byte[]> response = restTemplate.exchange(baseURL, HttpMethod.GET, httpEntity, byte[].class);
        //Since we are dealing with a binary files, response type would be byte array.

        if (response.getStatusCode() == HttpStatus.OK) {
            Files.write(Paths.get("demo.txt"), response.getBody());
        }

        return "File downloaded";
    }


}
