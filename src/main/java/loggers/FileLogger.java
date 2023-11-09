package main.java.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private static final Logger logger = LogManager.getLogger(FileLogger.class);

    public static void logToFile(String message) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/logs/app.log", true)) {
            fileWriter.write(message + "\n");
        } catch (IOException e) {
            logger.error("Problem with writing to file: {}", e.getMessage());
        }
    }
}
