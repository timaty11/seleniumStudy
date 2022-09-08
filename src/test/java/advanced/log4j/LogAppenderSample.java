package advanced.log4j;

import org.apache.log4j.*;
import org.apache.log4j.jdbc.JDBCAppender;

public class LogAppenderSample {

    public static void main(String[] args) {
        fileAppenderTest();
        jdbcAppenderTest();

    }


    public static void fileAppenderTest() {
        // TODO Auto-generated method stub

        BasicConfigurator.configure();
        Logger OurLogger = LogManager.getLogger("OurLogger");

        // Create a FileAppender object and
        // associate the file name to which you want the logs
        // to be directed to.
        // You will also have to set a layout also, here
        // We have chosen a SimpleLayout
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("logfile.txt");
        fileAppender.setLayout(new SimpleLayout());

        // Add the appender to our Logger Object.
        // from now onwards all the logs will be directed
        // to file mentioned by FileAppender
        OurLogger.addAppender(fileAppender);
        fileAppender.activateOptions();

        // Print some log 10 times
        int x = 0;
        while (x < 11) {
            OurLogger.info("This is just a log that I want to print " + x);
            x++;
        }
    }


    public static void jdbcAppenderTest() {
        // TODO Auto-generated method stub

        BasicConfigurator.configure();
        Logger OurLogger = LogManager.getLogger("OurLogger");

        // Create a JDBCAppender class instance
        JDBCAppender dataBaseAppender = new JDBCAppender();
        // Provide connection details to the
        // Database appender
        dataBaseAppender.setURL("jdbc:mysql://localhost/test"); //Connection url
        dataBaseAppender.setUser("User1"); //Username for the DB connection
        dataBaseAppender.setPassword("ThisPassword"); //Password for the DB connection
        dataBaseAppender.setDriver("com.mysql.jdbc.Driver"); // Drivers to use to connect to DB

        // Set the sql insert statement that you want to use
        dataBaseAppender.setSql("INSERT INTO LOGS VALUES ('%x', now() ,'%C','%p','%m'");

        // Activate the new options
        dataBaseAppender.activateOptions();

        // Attach the appender to the Logger
        OurLogger.addAppender(dataBaseAppender);

        int x = 0;
        while (x < 11) {
            OurLogger.debug("This is just a log that I want to print " + x);
            x++;
        }
    }

}
