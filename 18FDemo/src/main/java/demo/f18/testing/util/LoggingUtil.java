package demo.f18.testing.util;

import org.apache.log4j.Logger;

public class LoggingUtil {

	public static void trace(String message, Logger logger) {
		if (logger.isTraceEnabled()) {
			logger.trace(message);
		}

	}

	public static void trace(String message, Logger logger, Throwable throwable) {

		if (logger.isTraceEnabled()) {
			logger.trace(message, throwable);
		}

	}

	public static void debug(String message, Logger logger) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}

	}

	public static void debug(String message, Logger logger, Throwable throwable) {

		if (logger.isDebugEnabled()) {
			logger.debug(message, throwable);
		}

	}

	public static void info(String message, Logger logger) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}

	}

	public static void info(String message, Logger logger, Throwable throwable) {

		if (logger.isInfoEnabled()) {
			logger.info(message, throwable);
		}

	}

	public static void warn(String message, Logger logger) {
		logger.warn(message);
	}

	public static void warn(String message, Logger logger, Throwable throwable) {

		logger.warn(message, throwable);
	}

	public static void error(String message, Logger logger) {
		logger.error(message);

	}

	public static void error(String message, Logger logger, Throwable throwable) {

		logger.error(message, throwable);
	}

	public static void fatal(String message, Logger logger) {
		logger.fatal(message);
	}

	public static void fatal(String message, Logger logger, Throwable throwable) {

		logger.fatal(message, throwable);
	}
}