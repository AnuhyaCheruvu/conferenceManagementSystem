package assignment.ctf.util;

/**
 * Created by user on 2/18/2017.
 */
public class Constants {

    public static final String EVENT_PATTERN = "^(.+)\\s(\\d+)?\\s?((min)|(lightning))$";

    public static final int EVENT_NAME_INDEX = 1;
    public static final int EVENT_TIME_INDEX = 2;
    public static final int EVENT_DURATION_UNIT_INDEX = 3;


    public static final String MORNING_SESSION_START_TIME = "9:00AM";
    public static final String MORNING_SESSION_END_TIME = "12:00PM";

    public static final String LUNCH_SESSION_START_TIME = "12:00PM";
    public static final String LUNCH_SESSION_END_TIME = "1:00PM";
    public static final String LUNCH_EVENT_NAME = "Lunch";
    public  static final int LUNCH_EVENT_DURATION_IN_MIN = 60;

    public static final String AFTERNOON_SESSION_START_TIME = "01:00PM";
    public static final String AFTERNOON_SESSION_END_TIME = "04:00PM";
    public static final String AFTERNOON_SESSION_EXTENDED_END_TIME = "05:00PM";

    public static final String NETWORKING_SESSION_MIN_START_TIME = "04:00PM";
    public static final String NETWORKING_SESSION_MAX_START_TIME = "05:00PM";
    public static final String NETWORKING_SESSION_MIN_END_TIME = "05:00PM";
    public static final String NETWORKING_SESSION_MAX_END_TIME = "06:00PM";
    public static final String NETWORKING_EVENT_NAME= "Networking event";
    public  static final int NETWORKING_EVENT_DURATION_IN_MIN = 60;

}
