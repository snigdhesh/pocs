package com.demo;

import org.apache.logging.log4j.*;

public class Driver {

    static Logger log= LogManager.getLogger(Driver.class);

    public static void main(String args[]){
        System.out.println("begin logging");
        log.debug("Printing debug...");
/*        log.info("Printing info...");
        log.warn("Printing warn...");
        log.error("Printing error...");
        log.fatal("Printing fatal..");
        log.trace("Printing trace...");*/
        System.out.println("end logging");

    }
}
