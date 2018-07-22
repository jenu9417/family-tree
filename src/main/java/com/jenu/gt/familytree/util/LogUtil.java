package com.jenu.gt.familytree.util;

import java.util.logging.Logger;

/**
 * The Util Class LogUtil. Provides a common method to display the output.
 * 
 * @author janardhanan.s
 */
public class LogUtil {

	private LogUtil() {
		throw new IllegalAccessError("Access denied!!");
	}

	/**
	 * Log output.
	 *
	 * @param logger
	 *            the logger
	 * @param message
	 *            the message
	 */
	public static void logOutput(Logger logger, String message) {
		logger.info("# ---------------------- Output ---------------------- #");
		logger.info("");
		logger.info(message);
		logger.info("");
		logger.info("# ---------------------------------------------------- #");
	}

}
