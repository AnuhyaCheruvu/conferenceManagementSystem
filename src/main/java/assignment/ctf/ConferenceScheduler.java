package assignment.ctf;

import assignment.ctf.util.DurationUnit;
import assignment.ctf.util.TimeConvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static assignment.ctf.util.Constants.*;
import static assignment.ctf.util.Constants.EVENT_NAME_INDEX;

/**
 * Created by user on 2/18/2017.
 */
public class ConferenceScheduler {

    private Session morningSession;
    private Session lunchSession;
    private Session afternoonSession;
    private Session networkingSession;

    public Conference scheduleConference(BufferedReader input) throws IOException {
        List<Event> requestedEvents = new ArrayList();
        for (String line; (line = input.readLine()) != null; ) {
            line = line.trim();
            Event event = parseInputLine(line);
            requestedEvents.add(event);
        }

        return getConferenceDetails(requestedEvents);
    }

    private Conference getConferenceDetails(List<Event> requestedEvents) {
        Conference conference = new Conference();

        while (!requestedEvents.isEmpty()) {
            Track track = getConferenceTrack(requestedEvents);
            conference.addTrack(track);
        }

        return conference;
    }

    private Track getConferenceTrack(List<Event> requestedEvents) {
        Track track = new Track();

        morningSession = new Session(TimeConvertor.ConvertTimeIntoMin(MORNING_SESSION_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(MORNING_SESSION_END_TIME));
        lunchSession = new Session(TimeConvertor.ConvertTimeIntoMin(LUNCH_SESSION_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(LUNCH_SESSION_END_TIME));
        afternoonSession = new Session(TimeConvertor.ConvertTimeIntoMin(AFTERNOON_SESSION_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(AFTERNOON_SESSION_END_TIME),
                TimeConvertor.ConvertTimeIntoMin(AFTERNOON_SESSION_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(AFTERNOON_SESSION_EXTENDED_END_TIME));
        networkingSession = new Session(TimeConvertor.ConvertTimeIntoMin(NETWORKING_SESSION_MIN_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(NETWORKING_SESSION_MIN_END_TIME),
                TimeConvertor.ConvertTimeIntoMin(NETWORKING_SESSION_MAX_START_TIME),
                TimeConvertor.ConvertTimeIntoMin(NETWORKING_SESSION_MAX_END_TIME));

        addEventsToSessions(requestedEvents);

        Event lunchEvent = new Event(LUNCH_EVENT_NAME, LUNCH_EVENT_DURATION_IN_MIN, DurationUnit.MIN);
        this.lunchSession.addEvent(lunchEvent);

        Event networkingEvent = new Event(NETWORKING_EVENT_NAME, NETWORKING_EVENT_DURATION_IN_MIN, DurationUnit.MIN);
        this.networkingSession.addEvent(networkingEvent);
        this.afternoonSession.addExtendedSession(networkingSession);

        track.addAllSessions(this.morningSession, this.lunchSession, this.afternoonSession);
        return track;
    }

    private void addEventsToSessions(List<Event> requestedEvents) {
        Iterator eventIterator = requestedEvents.iterator();
        while (eventIterator.hasNext()) {
            Event event = (Event) eventIterator.next();

            int eventDuration = event.getDurationInMin();
            if (this.morningSession.hasDurationLeft(eventDuration)) {
                this.morningSession.addEvent(event);
            } else if (this.afternoonSession.hasDurationLeft(eventDuration)) {
                this.afternoonSession.addEvent(event);
            } else {
                break;
            }
            eventIterator.remove();
        }


    }

    public Event parseInputLine(String line) {
        Pattern eventPattern = Pattern.compile(EVENT_PATTERN);
        Matcher matcher = eventPattern.matcher(line);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Enter the input line in correct format");
        }

        String eventName = matcher.group(EVENT_NAME_INDEX);
        int eventDuration = matcher.group(EVENT_TIME_INDEX) == null ? 1 : Integer.parseInt(matcher.group(EVENT_TIME_INDEX));
        DurationUnit durationUnit = DurationUnit.getDurationUnit(matcher.group(EVENT_DURATION_UNIT_INDEX));

        Event event = new Event(eventName, eventDuration, durationUnit);
        ;

        return event;
    }


}
