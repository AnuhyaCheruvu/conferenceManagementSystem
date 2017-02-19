package assignment.ctf;

import assignment.ctf.util.DurationUnit;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 2/18/2017.
 */
public class SessionTest {

    @Test
    public void shouldAddEvent() throws Exception {
        Session morningSession = new Session(9*60, 12*60);
        Event event = new Event("JAVA", 60, DurationUnit.MIN);

        morningSession.addEvent(event);

        Assert.assertEquals(morningSession.getEvents().size(),1);

    }

    @Test(expected = IllegalStateException.class)
    public void shouldTrowExceptionWhenAnEventWithGreaterDurationIsAdded() throws Exception {
        Session morningSession = new Session(60, 120);
        Event javaEvent = new Event("JAVA", 60, DurationUnit.MIN);
        Event angularEvent = new Event("Angular", 120, DurationUnit.MIN);

        morningSession.addEvent(javaEvent);
        morningSession.addEvent(angularEvent);
    }

    @Test
    public void shouldReturnTrueWhenThereIsDurationTimeLeft() throws Exception {
        Session morningSession = new Session(9*60, 12*60, 9*60, 13*60);
        Event javaEvent = new Event("JAVA", 180, DurationUnit.MIN);
        Event angularEvent = new Event("Angular", 60, DurationUnit.MIN);

        morningSession.addEvent(javaEvent);

        Assert.assertTrue(morningSession.hasDurationLeft(angularEvent.getDurationInMin()));

    }

    @Test
    public void shouldAddExtendedSession() throws Exception {
        Session morningSession = new Session(9*60, 12*60, 9*60, 13*60);
        Session extendedSession = new Session(12*60, 13*60, 13*60, 14*60);
        Event javaEvent = new Event("JAVA", 180, DurationUnit.MIN);
        Event angularEvent = new Event("Angular", 60, DurationUnit.MIN);

        morningSession.addEvent(javaEvent);
        morningSession.addEvent(angularEvent);
        morningSession.addExtendedSession(extendedSession);

        Assert.assertEquals(13*60, extendedSession.getStartTime());

    }
}