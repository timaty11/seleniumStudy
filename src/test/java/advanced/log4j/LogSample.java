package advanced.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogSample {
    static Logger mainLogger = LogManager.getLogger(LogSample.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();

        ConsoleAppender appender = new ConsoleAppender();
        mainLogger.addAppender(appender);
        mainLogger.info("This is test log4j log");

    }

}
