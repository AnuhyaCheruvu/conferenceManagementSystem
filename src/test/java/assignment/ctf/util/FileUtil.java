package assignment.ctf.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 2/19/2017.
 */
public class FileUtil {

    public static BufferedReader getBufferedReaderForResourceFile(String file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return  reader;
    }


    public static boolean contentEquals(String resourceFile, String outputFile)
            throws IOException {
        BufferedReader fileReader = getBufferedReaderForResourceFile(resourceFile);
        BufferedReader outputReader = getBufferedReaderForResourceFile(outputFile);
        while (true) {
            String inputFileLine = getNextLine(fileReader);
            String outputFileLine = getNextLine(outputReader);
            if (inputFileLine == null && outputFileLine == null) {
                break;
            }

            if (inputFileLine == null || outputFileLine == null) {
                return false;
            }

            if (inputFileLine.equals(outputFileLine) == false) {
                return false;
            }
        }
        return true;
    }

    private static String getNextLine(BufferedReader reader) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                return null;
            }

            if (line.trim().length() != 0) {
                return line;
            }
        }
    }
}
