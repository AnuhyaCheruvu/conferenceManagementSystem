package assignment.ctf;

import assignment.ctf.util.FileUtil;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;

/**
 * Created by user on 2/19/2017.
 */
public class ConferenceSchedulerMainTest {

    @Test
    public void shouldScheduleConference() throws Exception {
        String[] args = new String[1];
        args[0] = "src/test/resources/Input.txt";
        ConferenceSchedulerMain.main(args);

        assertTrue(FileUtil.contentEquals("src/test/resources/ActualOutput.txt", "src/test/resources/Output.txt"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputFileNotSpecified() throws Exception {
        ConferenceSchedulerMain.main();
    }

    @Test
    public void shouldThrowIOException() throws Exception {
        String[] args = new String[1];
        args[0] = "src/test/resources/Input.txt";
        ConferenceScheduler conferenceScheduler =  Mockito.mock(ConferenceScheduler.class);
        Mockito.when(conferenceScheduler.scheduleConference((BufferedReader) anyObject())).thenThrow(IOException.class);

        ConferenceSchedulerMain.main(args);

    }
}