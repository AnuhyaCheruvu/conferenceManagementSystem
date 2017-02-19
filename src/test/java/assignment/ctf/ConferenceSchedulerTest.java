package assignment.ctf;

import assignment.ctf.util.DurationUnit;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by user on 2/18/2017.
 */
public class ConferenceSchedulerTest {

    @Test
    public void shouldParseInputLineToEventObject() throws Exception {
        ConferenceScheduler conferenceScheduler = new ConferenceScheduler();
        String input = "Writing Fast Tests Against Enterprise Rails 60min\n";
        Event expectedEvent = new Event("Writing Fast Tests Against Enterprise Rails", 60, DurationUnit.MIN);

        Event actualEvent = conferenceScheduler.parseInputLine(input);

        Assert.assertEquals(expectedEvent, actualEvent);
    }

    @Test
    public void shouldParseInputLineToEventObjectWithTimeAsLightning() throws Exception {
        ConferenceScheduler conferenceScheduler = new ConferenceScheduler();
        String input = "Writing Fast Tests Against Enterprise Rails lightning\n";
        Event expectedEvent = new Event("Writing Fast Tests Against Enterprise Rails", 1, DurationUnit.LIGHTNING);

        Event actualEvent = conferenceScheduler.parseInputLine(input);

        Assert.assertEquals(expectedEvent, actualEvent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputLineInWrongFormat() throws Exception {
        ConferenceScheduler conferenceScheduler = new ConferenceScheduler();
        String input = "60min\n";

        conferenceScheduler.parseInputLine(input);

    }

    @Test
    public void shouldScheduleConference() throws Exception {
        BufferedReader input = new BufferedReader(new FileReader("src/test/resources/input.txt"));
        ConferenceScheduler conferenceScheduler = new ConferenceScheduler();

        Conference scheduledConference = conferenceScheduler.scheduleConference(input);

        Assert.assertEquals(2, scheduledConference.getTracks().size());
    }
}