package assignment.ctf;

import assignment.ctf.util.FileUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 2/19/2017.
 */
public class ConferenceSchedulerMainTest {

    @Test
    public void shouldScheduleConference() throws Exception {
        String[] args = new String[2];
        args[0] = "src/test/resources/input.txt";
        args[1] = "src/test/resources/ActualOutput.txt";
        ConferenceSchedulerMain.main(args);

        assertTrue(FileUtil.contentEquals("src/test/resources/ActualOutput.txt", "src/test/resources/ExpectedOutput.txt"));

    }
}