package assignment.ctf.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 2/18/2017.
 */
public class TimeConvertorTest {

    @Test
    public void shoudConvertAMTimeFormatToMin() throws Exception {
        String time = "9:00AM";

        int min = TimeConvertor.ConvertTimeIntoMin(time);

        Assert.assertEquals(540, min);
    }

    @Test
    public void shouldConvertPMTimeFormatToMin() throws Exception {
        String time = "3:30PM";

        int min = TimeConvertor.ConvertTimeIntoMin(time);

        Assert.assertEquals(930, min);

    }

    @Test
    public void shouldConvertNoonTimeFormatToMin() throws Exception {
        String time = "12:30PM";

        int min = TimeConvertor.ConvertTimeIntoMin(time);

        Assert.assertEquals(750, min);

    }

    @Test
    public void shouldConvertMinToStringForPM() throws Exception {
        String time = TimeConvertor.ConvertMinToTime(930);

        Assert.assertEquals("03:30PM", time);

    }

    @Test
    public void shouldConvertMinToStringForNoon() throws Exception {
        String time = TimeConvertor.ConvertMinToTime(720);

        Assert.assertEquals("12:00PM", time);

    }
    @Test
    public void shouldConvertMinToStringForAM() throws Exception {
        String time = TimeConvertor.ConvertMinToTime(0);

        Assert.assertEquals("00:00AM", time);

    }

}