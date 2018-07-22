package com.jenu.gt.familytree.util;

import java.util.logging.Logger;

public class LogUtil {

	private LogUtil() {
		throw new IllegalAccessError("Access denied!!");
	}

	public static void logOutput(Logger logger, String message) {
		logger.info("# ---------------------- Output ---------------------- #");
		logger.info("");
		logger.info(message);
		logger.info("");
		logger.info("# ---------------------------------------------------- #");
	}

}
