package assignment.ctf.util;

/**
 * Created by user on 2/18/2017.
 */
public class TimeConvertor {

    private static int HOURS_TO_MIN_MULTIPLIER = 60;
    private static int HOUR_CONVERTOR_CONST = 12;

    public static int ConvertTimeIntoMin(String inputTime) {
        String time[] = inputTime.split(":");
        int hours = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1].substring(0, 2));
        boolean isAM = inputTime.endsWith("AM") ? true : false;

        if (!isAM && hours != 12) {
            return HOURS_TO_MIN_MULTIPLIER * (hours + HOUR_CONVERTOR_CONST) + min;
        }
        return HOURS_TO_MIN_MULTIPLIER * hours + min;

    }

    public static String ConvertMinToTime(int timeInMin) {
        StringBuilder time = new StringBuilder();

        int hours = timeInMin / HOURS_TO_MIN_MULTIPLIER;
        int min = timeInMin % HOURS_TO_MIN_MULTIPLIER;
        String displayValue = getAMorPM(hours, timeInMin);
        time.append(getHoursInString(hours));
        time.append(":");
        time.append(getMinInString(min));
        time.append(displayValue);

        return time.toString();
    }

    private static String getAMorPM(int hours, int timeInMin) {
        if((timeInMin<60) ||(hours<12)){
            return "AM";
        }
        return "PM";
    }

    private static String getMinInString(int min) {
        StringBuilder minInString = new StringBuilder();
        if (min <10) {
            minInString.append("0");
        }
        minInString.append(Integer.toString(min));

        return minInString.toString();
    }

    private static String getHoursInString(int hours) {
        StringBuilder hoursInString = new StringBuilder();
        String str = hours > 12 ?Integer.toString(hours - 12) :  Integer.toString(hours);
        hoursInString.append(str.length() == 1 ? "0" + str : str);

        return hoursInString.toString();
    }
}
