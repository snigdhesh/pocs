# Sending an attachment file via REST API, with spring boot
###### demonstrated formats: pdf, text and json

### Things to remember

``` headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.json"); ```  
This statement decides what file to download, and with what name and with what extension.