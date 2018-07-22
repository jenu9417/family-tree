package com.jenu.gt.familytree.relation.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * The CustomLogFormatter class for {@link Logger}. <br>
 * <br>
 * <b>Format: </b><br>
 * 'Date' 'Time' 'Timezone' 'Log_Level' [ 'Thread_ID' ]
 * 'Class_Name'::'Method_Name' - 'Message'
 * 
 * @author janardhanan.s
 */
public class CustomLogFormatter extends Formatter {

	private static final char DOT = '.';
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String METHOD_SEPERATOR = "::";
	private static final String MESSAGE_SEPERATOR = " - ";

	private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss:SSS zzz");

	@Override
	public String format(LogRecord record) {
		final String fullClassName = record.getSourceClassName();
		final String className = fullClassName.substring(fullClassName.lastIndexOf(DOT) + 1);
		return dateFormatter.format(new Date(record.getMillis())) + SPACE + record.getLevel() + SPACE + "[ "
				+ record.getThreadID() + " ]" + SPACE + className + METHOD_SEPERATOR + record.getSourceMethodName()
				+ MESSAGE_SEPERATOR + record.getMessage() + NEW_LINE;
	}

}
