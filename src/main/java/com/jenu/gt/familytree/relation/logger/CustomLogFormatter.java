package com.jenu.gt.familytree.relation.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String METHOD_SEPERATOR = "::";
	private static final String MESSAGE_SEPERATOR = " - ";

	private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:SSS zzz");

	@Override
	public String format(LogRecord record) {
		return dateFormatter.format(new Date(record.getMillis())) + SPACE + record.getLevel() + SPACE + "[ "
				+ record.getThreadID() + " ]" + SPACE + record.getSourceClassName() + METHOD_SEPERATOR
				+ record.getSourceMethodName() + MESSAGE_SEPERATOR + record.getMessage() + NEW_LINE;
	}

}
