package carconfig.exception;

import java.io.*;
import java.util.Calendar;

/**
 * LogJournal is the class that holds functional for work with journal of logs
 *
 * @author Anoshko Aleksei
 * @version %I%, %G%
 */
public class LogJournal {

    static File logFile = new File("logs.txt");

    /**
     * Creates a record about an error in the journal of logs
     *
     * @param errorCode    a code of the error
     * @param errorType    a type of the error
     * @param description  a description of the error
     */
    static void createRecord(int errorCode, String errorType, String description) {

        try {
            FileWriter writer = null;
            if (logFile.exists()) {
                writer = new FileWriter(logFile, true);
            } else {
                writer = new FileWriter(logFile);
                writer.write("| DATE                        | CODE   | TYPE                | DESCRIPTION            |\n");
                writer.write("|-------------------------------------------------------------------------------------|\n");
            }
            String record = String.format("|%s | %6s | %20s | %s\n", Calendar.getInstance().getTime(), errorCode, errorType, description);
            writer.write(record);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}