package com.log.log4j;//package com.log.log4j;
//
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.helpers.Loader;
//
//public class Log4jTest {
//
//    private static final Logger logger = Logger.getLogger(Log4jTest.class);
//
//    public static void main(String[] args) {
//
//        PropertyConfigurator.configure(Loader.getResource("conf/log4j.properties"));
//
//        if (logger.isTraceEnabled()) {
//            logger.debug("log4j trace message");
//        }
//        if (logger.isDebugEnabled()) {
//            logger.debug("log4j debug message");
//        }
//        if (logger.isInfoEnabled()) {
//            logger.debug("log4j info message");
//        }
//    }
//}
