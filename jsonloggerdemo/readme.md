# Implementing json logging

##### step1
Make sure you have following dependencies on pom.xml
 
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.10.0</version>
        </dependency>
        
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.10.0</version>
        </dependency>
        
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>[2.8.11.1,)</version>
        </dependency>
                     
         <dependency>
           <groupId>com.fasterxml.jackson.core</groupId>
           <artifactId>jackson-databind</artifactId>
           <version>[2.8.11.1,)</version>
         </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>[2.8.11.1,)</version>
        </dependency>

##### step2
Add `log4j2.xml` under resources folder, which looks like below

    <?xml version="1.0" encoding="UTF-8"?>
    <Configuration status="WARN">
        <Appenders>
            <Console name="Console" target="SYSTEM_OUT">
                <JSONLayout />
            </Console>
        </Appenders>
        <Loggers>
            <Root level="trace">
                <AppenderRef ref="Console"/>
            </Root>
        </Loggers>
    </Configuration>

##### step3

    import org.apache.logging.log4j.*;

    static Logger log = LogManager.getLogger(Driver.class);
    
    log.debug(""Printing debug...");
    

## Expected output pattern

    {
      "timeMillis" : 1549913516556,
      "thread" : "main",
      "level" : "DEBUG",
      "loggerName" : "com.demo.Driver",
      "message" : "Printing debug...",
      "endOfBatch" : false,
      "loggerFqcn" : "org.apache.logging.log4j.spi.AbstractLogger",
      "threadId" : 1,
      "threadPriority" : 5
    }