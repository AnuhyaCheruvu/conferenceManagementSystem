package assignment.ctf;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by user on 2/19/2017.
 */
public class ConferenceSchedulerMain {

    public static void main(String[] args) {
        if(args.length <2) {
            throw  new IllegalArgumentException("Input file and output file should be enter as the argument");
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            Conference conference = new ConferenceScheduler().scheduleConference(reader);
            Files.write(Paths.get(outputFile.toURI()), conference.toString().getBytes());

        } catch (IOException e) {
            String msg = "Cannot read from input file: " + inputFile.getAbsolutePath();
            System.out.println(msg);
            System.exit(1);
        }
    }

}
