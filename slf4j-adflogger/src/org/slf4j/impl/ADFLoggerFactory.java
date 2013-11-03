package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import oracle.adf.share.logging.ADFLogger;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * Adapted from the JDK14 LoggerFactory 
 * 
 * ADFLoggerFactory is an implementation of {@link ILoggerFactory} returning
 * the appropriately named {@link ADFLoggerAdapter} instance.
 * 
 * @author Arun Manivannan (Adapted from JDK14 and Log4J adapters)
 * 
 */
public class ADFLoggerFactory implements ILoggerFactory {

  // key: name (String), value: a ADFLoggerAdapter;
  ConcurrentMap<String, Logger> loggerMap;

  public ADFLoggerFactory() {
    loggerMap =new ConcurrentHashMap<String, Logger>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
   */
  public synchronized Logger getLogger(String name) {
	//Since ADFLogger is based on JUL, the root logger is named ""
    if(name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
      name = "";
    }

    Logger slf4jLogger = loggerMap.get(name);
    if (slf4jLogger != null)
      return slf4jLogger;
    else {
      ADFLogger adfLogger = ADFLogger.createADFLogger(name);
      //Logger newInstance = new ADFLoggerAdapter(julLogger);
      Logger newInstance = new ADFLoggerAdapter(adfLogger);
      Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
      return oldInstance == null ? newInstance : oldInstance;
    }
  }
}

