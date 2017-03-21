package com.dynatrace.plugin.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.dynatrace.diagnostics.sdk.resources.BaseConstants;


public class HelperUtils {
	private static final Logger log = Logger.getLogger(HelperUtils.class.getName());
	
	public static String getExceptionAsString(Exception e) {
		if (log.isLoggable(Level.FINER)) {
			log.finer("Entering getExceptionAsString method");
		}
		String msg;
		if ((msg = e.getMessage()) == null) {
			msg = BaseConstants.DASH;
		}
		return new StringBuilder(e.getClass().getCanonicalName()
				+ " exception occurred. Message = '").append(msg)
				.append("'; Stacktrace is '").append(getStackTraceAsString(e))
				.append("'").toString();
	}

	public static String getStackTraceAsString(Exception e) {
		if (log.isLoggable(Level.FINER)) {
			log.finer("Entering getStackTraceAsString method");
		}
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(ba));
		return ba.toString();
	}
}
