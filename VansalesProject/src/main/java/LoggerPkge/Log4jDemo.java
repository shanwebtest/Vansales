package LoggerPkge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	 
	public static void main(String[] args) {
		System.out.println("test start");
		logger.info("Test message");
		logger.error("test Error");
		logger.warn("Test warning message");
		logger.fatal("Test fater errror");
		
		
	}

}
