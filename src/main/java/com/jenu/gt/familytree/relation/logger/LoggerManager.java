package com.jenu.gt.familytree.relation.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class LoggerManager. Initializes Logger configuration with a console
 * handler and a file handler. By default the file will be written under the
 * name 'family-tree.log'
 * 
 * @author janardhanan.s
 */
public class LoggerManager {

	private static final String DEFAULT_FILE_NAME = "family_tree.log";

	private LoggerManager() throws IllegalAccessException {
		throw new IllegalAccessException("Illegal access");
	}

	public static void initialize() {
		try {
			// get the global logger to configure it
			final Logger logger = Logger.getLogger("com.jenu");
			logger.setLevel(Level.INFO);

			logger.setUseParentHandlers(false);

			// create a text formatter
			final CustomLogFormatter textFormatter = new CustomLogFormatter();

			final ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setFormatter(textFormatter);

			final FileHandler fileHandler = new FileHandler(DEFAULT_FILE_NAME);
			fileHandler.setFormatter(textFormatter);

			logger.addHandler(consoleHandler);
			logger.addHandler(fileHandler);

			logger.info("Initial Log Message");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
