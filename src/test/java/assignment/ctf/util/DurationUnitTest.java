package assignment.ctf.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 2/19/2017.
 */
public class DurationUnitTest {

    @Test
    public void shouldReturnDurationUnit() throws Exception {
        DurationUnit min = DurationUnit.getDurationUnit("min");
        DurationUnit lightning = DurationUnit.getDurationUnit("lightning");

        assertEquals(DurationUnit.MIN, min);
        assertEquals(DurationUnit.LIGHTNING, lightning);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGetDurationunitInputDoesntMatch() throws Exception {
        DurationUnit.getDurationUnit("hours");
    }
}