package assignment.ctf;

import assignment.ctf.util.DurationUnit;

/**
 * Created by user on 2/17/2017.
 */
public class Event {
    private String name;
    private int duration;
    private DurationUnit time;

    public Event(String name, int duration, DurationUnit time) {
        this.name = name;
        this.duration = duration;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public int getDurationInMin() {
        return this.duration*this.time.getBaseUnit();
    }

    public DurationUnit getTime() {
        return this.time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (duration != event.duration) return false;
        if (!name.equals(event.name)) return false;
        return time == event.time;

    }

    @Override
    public String toString() {
        return this.getName() + " " + this.duration + this.time.getRepresentation();
    }
}
