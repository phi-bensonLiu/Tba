package service;

import org.apache.log4j.Logger;

public class Log {
	
	static Logger log = Logger.getLogger(Log.class.getName());
	
	 public static void logDebug(String message) {
		log.debug(message);
	}

	public static void logInfo(String message) {
		log.info(message);
	}
	public static void logInfo(String message, Exception e) {
		log.info(message + e);
	}
	
	public static void logError(String message) {
		log.error(message);
	}
	public static void logError(String message, Exception e) {
		log.error(message + e);
		log.error("錯誤訊息", e);
	}
}
