package tz.co.niajiri.qa.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    //    Logger Interface: Provides methods for logging at different levels.
    //    LogManager Class: Used to obtain Logger instances.
    //    Returns a Logger with the name of the calling class.
    //private static Logger logger = LogManager.getLogger();
    private static Logger logger(Class<?> clazz){
        return LogManager.getLogger(clazz);
    }

    // Need to create below methods, so that they can be called
    public static void info(Class<?> clazz, String message) {
        logger(clazz).info(message);
    }

//    public static void warn(String message) {
//        logger.warn(message);
//    }
//
//    public static void error(String message) {
//        logger.error(message);
//    }
//
//    public static void fatal(String message) {
//        logger.fatal(message);
//    }
//
//    public static void debug(String message) {
//        logger.debug(message);
//    }

//    // Need to create below methods, so that they can be called
//
//    public static Logger logger(Class<?> clazz){
//        return LogManager.getLogger(clazz);
//    }

//    public static void info(Class<?> clazz, String message) {
//        logger(clazz).info(message);
//    }
//
//    public static void warn(Class<?> clazz, String message) {
//        logger(clazz).warn(message);
//    }
//
//    public static void error(Class<?> clazz, String message) {
//        logger(clazz).error(message);
//    }
//
//    public static void fatal(Class<?> clazz, String message) {
//        logger(clazz).fatal(message);
//    }
//
//    public static void debug(Class<?> clazz, String message) {
//        logger(clazz).debug(message);
//    }
}
