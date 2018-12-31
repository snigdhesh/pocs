# Sending an attachment file via REST API, with spring boot
###### demonstrated formats: pdf, text and json
###### sources and references
```
    https://stackoverflow.com/questions/11553042/the-system-cannot-find-the-file-specified-in-java
    https://stackoverflow.com/questions/35680932/download-a-file-from-spring-boot-rest-service
    https://www.leveluplunch.com/java/tutorials/032-return-file-from-spring-rest-webservice/#create-request-method
```

### Things to remember

This can be done by two methods.  
**Method1:**

Refer to *FileDemoController* class

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

**Method2:**

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


### Important Note

    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.json");  
      
The above statement decides what file to download, and with what name and with what extension, so this statement is very *important*