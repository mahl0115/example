package com.log.logging;

import java.util.logging.Logger;

public class LoggingTest {

    private static final Logger logger = Logger.getLogger(LoggingTest.class.getName());

    public static void main(String[] args) {
        logger.info("hello");
    }
}
