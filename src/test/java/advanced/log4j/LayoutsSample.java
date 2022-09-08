package advanced.log4j;

import org.apache.log4j.*;

public class LayoutsSample {

    static Logger mainLogger = LogManager.getLogger(LayoutsSample.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        ConsoleAppender appender = new ConsoleAppender();
        appender.activateOptions();

        PatternLayout layoutHelper = new PatternLayout();
        layoutHelper.setConversionPattern("%-5p [%t]: %m%n");
        layoutHelper.activateOptions();

        appender.setLayout(layoutHelper);
        mainLogger.addAppender(appender);

        mainLogger.info("This is test 1 log4j log");

        layoutHelper.setConversionPattern("%C %m%n");
        mainLogger.info("This is test 2 log4j log");

    }

}
