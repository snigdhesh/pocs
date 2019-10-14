### Printing pretty  json in console

###### source: https://www.baeldung.com/jackson-object-mapper-tutorial 

- Add following dependency to pom.xml

```
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>[2.9.5,)</version>
</dependency>
```
- Add getObjectMapper method in controller class.
```
public ObjectMapper getObjectMapper(){
    ObjectMapper objectMapper=new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    return objectMapper;
}
```
- Add Logger to your class, I am using slf4j here.
```
Logger log = LoggerFactory.getLogger(this.getClass());
```
- Add 3 parameters to log.info as shown below
    1. place holders
    2. line saparator
    3. model object (courseList)

```
ObjectMapper objectMapper = getObjectMapper();
log.info("{},{}", System.lineSeparator(), objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(courseList));
```

This will give you pretty json on IDE console, like below

```
[ {
  "courseName" : "Java desing patterns",
  "author" : "HeadFirst",
  "price" : "$45"
}, {
  "courseName" : "Web Development for dummies",
  "author" : "Dummies",
  "price" : "$65"
} ]
```
