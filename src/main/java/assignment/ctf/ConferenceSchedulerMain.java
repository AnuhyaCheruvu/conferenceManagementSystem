package assignment.ctf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by user on 2/19/2017.
 */
public class ConferenceSchedulerMain {

    public static void main(String... args) {
        if(args.length <1) {
            throw  new IllegalArgumentException("Input file should be entered as the argument\n" +
                    "Usage:\t java -jar /path/to/conference-track-management-1.0.jar /path/to/input_file");
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(inputFile.getParent(), "Output.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            Conference conference = new ConferenceScheduler().scheduleConference(reader);
            System.out.println(outputFile.getAbsoluteFile()+ "Contains the Scheduled Conference track");
            Files.write(Paths.get(outputFile.toURI()), conference.toString().getBytes());

        } catch (IOException e) {
            String msg = "Cannot read from input file: " + inputFile.getAbsolutePath();
            System.out.println(msg);
            System.exit(1);
        }
    }

}
