package assignment.ctf;

import assignment.ctf.util.TimeConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2/17/2017.
 */
public class Session {
    private List<Event> events;
    private int startTime;
    private int endTime;
    private int remainingDuration;
    private int extendedStartTime;
    private int extendedEndTime;
    private Session extendedSession;

    public Session(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.remainingDuration = endTime - startTime;
        this.extendedStartTime = startTime;
        this.extendedEndTime = endTime;
        this.events = new ArrayList<Event>();
    }

    public Session(int startTime, int endTime, int extendedStartTime, int extendedEndTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.extendedStartTime = extendedStartTime;
        this.extendedEndTime = extendedEndTime;
        this.remainingDuration = this.extendedEndTime - this.extendedStartTime;
        this.events = new ArrayList<Event>();
    }

    public List<Event> getEvents() {
        return events;
    }


    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }


    public int getRemainingDuration() {
        return remainingDuration;
    }


    public void addEvent(Event event) {
        if (hasDurationLeft(event.getDurationInMin())) {
            events.add(event);
            this.remainingDuration -= event.getDurationInMin();
        } else {
            throw new IllegalStateException("Event " + event.getName() + " of duration " + event.getDurationInMin() + " cannot be added into this session");
        }
    }

    public boolean hasDurationLeft(int eventDuration) {
        if (this.remainingDuration >= eventDuration) {
            return true;
        }
        return false;
    }

    public void addExtendedSession(Session extendedSession) {
        if (this.remainingDuration < extendedSession.extendedStartTime - extendedSession.startTime) {
            extendedSession.startTime = extendedSession.extendedStartTime;
        }
        this.extendedSession = extendedSession;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int time = this.startTime;
        for(Event event:this.events) {
            String timeInString = TimeConvertor.ConvertMinToTime(time);
            builder.append(timeInString + " ");
            builder.append(event + " ");
            builder.append("\n");
            time += event.getDurationInMin();
        }
        if(this.extendedSession!=null){
            builder.append(extendedSession.toString());
        }

        return builder.toString();
    }
}
