package Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    // single instance
    private static Logger instance;

    private FileWriter writer;
    private String fileName = "log.txt";

    // private constructor
    private Logger() {
        try {
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("Error opening log file");
        }
    }

    // get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // write message to file
    public void write(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    // change file name
    public void setFileName(String newFileName) {
        try {
            writer.close();
            fileName = newFileName;
            writer = new FileWriter(fileName, true);
        } catch (IOException e) {
            System.out.println("Error changing log file");
        }
    }

    // close file
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}


