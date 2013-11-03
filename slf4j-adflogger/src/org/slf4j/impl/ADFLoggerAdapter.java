package org.slf4j.impl;

import java.util.logging.Level;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.share.logging.internal.diagnostic.ADFLogRecord;

import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/**
 * (Adapted from JDK14 and Log4J adapters)
 * 
 */
public class ADFLoggerAdapter extends MarkerIgnoringBase implements LocationAwareLogger {

	private static final long serialVersionUID = -4540559841055464215L;
	
	//Arun - Please note that the SELF field is very important to filter out the Adapter stack frames off the application stack frames 
	static String SELF = ADFLoggerAdapter.class.getName();
	static String SUPER = MarkerIgnoringBase.class.getName();
	  
	transient final ADFLogger logger;

	  // WARN: ADFLoggerAdapter constructor should have only package access so
	  // that only ADFLoggerFactory be able to create one.
	  ADFLoggerAdapter(ADFLogger logger) {
	    this.logger = logger;
	    this.name = logger.getName();
	  }

	  /**
	   * Is this logger instance enabled for the FINEST level?
	   * 
	   * @return True if this Logger is enabled for level FINEST, false otherwise.
	   */
	  public boolean isTraceEnabled() {
	    return logger.isLoggable(Level.FINEST);
	  }

	  /**
	   * Log a message object at level FINEST.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void trace(String msg) {
	    if (logger.isLoggable(Level.FINEST)) {
	      log(SELF, Level.FINEST, msg, null);
	    }
	  }

	  /**
	   * Log a message at level FINEST according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for level FINEST.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void trace(String format, Object arg) {
	    if (logger.isLoggable(Level.FINEST)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      log(SELF, Level.FINEST, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level FINEST according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the FINEST level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void trace(String format, Object arg1, Object arg2) {
	    if (logger.isLoggable(Level.FINEST)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      log(SELF, Level.FINEST, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level FINEST according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the FINEST level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void trace(String format, Object... argArray) {
	    if (logger.isLoggable(Level.FINEST)) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      log(SELF, Level.FINEST, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log an exception (throwable) at level FINEST with an accompanying message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void trace(String msg, Throwable t) {
	    if (logger.isLoggable(Level.FINEST)) {
	      log(SELF, Level.FINEST, msg, t);
	    }
	  }

	  /**
	   * Is this logger instance enabled for the FINE level?
	   * 
	   * @return True if this Logger is enabled for level FINE, false otherwise.
	   */
	  public boolean isDebugEnabled() {
	    return logger.isLoggable(Level.FINE);
	  }

	  /**
	   * Log a message object at level FINE.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void debug(String msg) {
	    if (logger.isLoggable(Level.FINE)) {
	      log(SELF, Level.FINE, msg, null);
	    }
	  }

	  /**
	   * Log a message at level FINE according to the specified format and argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for level FINE.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void debug(String format, Object arg) {
	    if (logger.isLoggable(Level.FINE)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      log(SELF, Level.FINE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level FINE according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the FINE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void debug(String format, Object arg1, Object arg2) {
	    if (logger.isLoggable(Level.FINE)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      log(SELF, Level.FINE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level FINE according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the FINE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void debug(String format, Object... argArray) {
	    if (logger.isLoggable(Level.FINE)) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      log(SELF, Level.FINE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log an exception (throwable) at level FINE with an accompanying message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void debug(String msg, Throwable t) {
	    if (logger.isLoggable(Level.FINE)) {
	      log(SELF, Level.FINE, msg, t);
	    }
	  }

	  /**
	   * Is this logger instance enabled for the INFO level?
	   * 
	   * @return True if this Logger is enabled for the INFO level, false otherwise.
	   */
	  public boolean isInfoEnabled() {
	    return logger.isLoggable(Level.INFO);
	  }

	  /**
	   * Log a message object at the INFO level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void info(String msg) {
	    if (logger.isLoggable(Level.INFO)) {
	      log(SELF, Level.INFO, msg, null);
	    }
	  }

	  /**
	   * Log a message at level INFO according to the specified format and argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void info(String format, Object arg) {
	    if (logger.isLoggable(Level.INFO)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      log(SELF, Level.INFO, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at the INFO level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void info(String format, Object arg1, Object arg2) {
	    if (logger.isLoggable(Level.INFO)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      log(SELF, Level.INFO, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level INFO according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the INFO level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void info(String format, Object... argArray) {
	    if (logger.isLoggable(Level.INFO)) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      log(SELF, Level.INFO, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log an exception (throwable) at the INFO level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void info(String msg, Throwable t) {
	    if (logger.isLoggable(Level.INFO)) {
	      log(SELF, Level.INFO, msg, t);
	    }
	  }

	  /**
	   * Is this logger instance enabled for the WARNING level?
	   * 
	   * @return True if this Logger is enabled for the WARNING level, false
	   *         otherwise.
	   */
	  public boolean isWarnEnabled() {
	    return logger.isLoggable(Level.WARNING);
	  }

	  /**
	   * Log a message object at the WARNING level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void warn(String msg) {
	    if (logger.isLoggable(Level.WARNING)) {
	      log(SELF, Level.WARNING, msg, null);
	    }
	  }

	  /**
	   * Log a message at the WARNING level according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARNING level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void warn(String format, Object arg) {
	    if (logger.isLoggable(Level.WARNING)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      log(SELF, Level.WARNING, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at the WARNING level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARNING level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void warn(String format, Object arg1, Object arg2) {
	    if (logger.isLoggable(Level.WARNING)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      log(SELF, Level.WARNING, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level WARNING according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the WARNING level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param argArray
	   *          an array of arguments
	   */
	  public void warn(String format, Object... argArray) {
	    if (logger.isLoggable(Level.WARNING)) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
	      log(SELF, Level.WARNING, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log an exception (throwable) at the WARNING level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void warn(String msg, Throwable t) {
	    if (logger.isLoggable(Level.WARNING)) {
	      log(SELF, Level.WARNING, msg, t);
	    }
	  }

	  /**
	   * Is this logger instance enabled for level SEVERE?
	   * 
	   * @return True if this Logger is enabled for level SEVERE, false otherwise.
	   */
	  public boolean isErrorEnabled() {
	    return logger.isLoggable(Level.SEVERE);
	  }

	  /**
	   * Log a message object at the SEVERE level.
	   * 
	   * @param msg
	   *          - the message object to be logged
	   */
	  public void error(String msg) {
	    if (logger.isLoggable(Level.SEVERE)) {
	      log(SELF, Level.SEVERE, msg, null);
	    }
	  }

	  /**
	   * Log a message at the SEVERE level according to the specified format and
	   * argument.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the SEVERE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg
	   *          the argument
	   */
	  public void error(String format, Object arg) {
	    if (logger.isLoggable(Level.SEVERE)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg);
	      log(SELF, Level.SEVERE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at the SEVERE level according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the SEVERE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arg1
	   *          the first argument
	   * @param arg2
	   *          the second argument
	   */
	  public void error(String format, Object arg1, Object arg2) {
	    if (logger.isLoggable(Level.SEVERE)) {
	      FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
	      log(SELF, Level.SEVERE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log a message at level SEVERE according to the specified format and
	   * arguments.
	   * 
	   * <p>
	   * This form avoids superfluous object creation when the logger is disabled
	   * for the SEVERE level.
	   * </p>
	   * 
	   * @param format
	   *          the format string
	   * @param arguments
	   *          an array of arguments
	   */
	  public void error(String format, Object... arguments) {
	    if (logger.isLoggable(Level.SEVERE)) {
	      FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
	      log(SELF, Level.SEVERE, ft.getMessage(), ft.getThrowable());
	    }
	  }

	  /**
	   * Log an exception (throwable) at the SEVERE level with an accompanying
	   * message.
	   * 
	   * @param msg
	   *          the message accompanying the exception
	   * @param t
	   *          the exception (throwable) to log
	   */
	  public void error(String msg, Throwable t) {
	    if (logger.isLoggable(Level.SEVERE)) {
	      log(SELF, Level.SEVERE, msg, t);
	    }
	  }

	  /**
	   * Log the message at the specified level with the specified throwable if any.
	   * This method creates a LogRecord and fills in caller date before calling
	   * this instance's JDK14 logger.
	   * 
	   * See bug report #13 for more details.
	   * 
	   * @param level
	   * @param msg
	   * @param t
	   */
	  private void log(String callerFQCN, Level level, String msg, Throwable t) {
	    // millis and thread are filled by the constructor
		ADFLogRecord logRecord=new ADFLogRecord(level, msg);
  		logRecord.setLoggerName(getName());
  		logRecord.setThrown(t);
  		
	    fillCallerData(callerFQCN, logRecord);
	    logger.log(logRecord);

	  }

	  /**
	   * Fill in caller data if possible.
	   * 
	   * @param record
	   *          The record to update
	   */
	  final private void fillCallerData(String callerFQCN, ADFLogRecord record) {
	    StackTraceElement[] steArray = new Throwable().getStackTrace();

	    int selfIndex = -1;
	    for (int i = 0; i < steArray.length; i++) {
	      final String className = steArray[i].getClassName();
	      if (className.equals(callerFQCN) || className.equals(SUPER)) {
	        selfIndex = i;
	        break;
	      }
	    }

	    int found = -1;
	    for (int i = selfIndex + 1; i < steArray.length; i++) {
	      final String className = steArray[i].getClassName();
	      if (!(className.equals(callerFQCN) || className.equals(SUPER))) {
	        found = i;
	        break;
	      }
	    }

	    if (found != -1) {
	      StackTraceElement ste = steArray[found];
	      // setting the class name has the side effect of setting
	      // the needToInferCaller variable to false.
	      record.setSourceClassName(ste.getClassName());
	      record.setSourceMethodName(ste.getMethodName());
	    }
	  }

	 public void log(Marker marker, String callerFQCN, int level, String msg,
      Object[] argArray, Throwable t) {
	  Level adfLevel;
	    switch (level) {
	    case LocationAwareLogger.TRACE_INT:
	      adfLevel = Level.FINEST;
	      break;
	    case LocationAwareLogger.DEBUG_INT:
	      adfLevel = Level.FINE;
	      break;
	    case LocationAwareLogger.INFO_INT:
	      adfLevel = Level.INFO;
	      break;
	    case LocationAwareLogger.WARN_INT:
	      adfLevel = Level.WARNING;
	      break;
	    case LocationAwareLogger.ERROR_INT:
	      adfLevel = Level.SEVERE;
	      break;
	    default:
	      throw new IllegalStateException("Level number " + level
	          + " is not recognized.");
	    }
	    
	    if (logger.isLoggable(adfLevel)) {
		      log(callerFQCN, adfLevel, msg, t);
		}
  	}
}
