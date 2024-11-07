package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteDataToCsv {

    public static void writeDataFromPageToCsv(String data) {
        File csvFile = new File("src/test/resources/transactions.csv");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.println(data);
        writer.close();
    }
}
