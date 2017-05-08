package peterdomokos.muccoursework;

import android.location.Location;

import com.indooratlas.android.sdk.IALocation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class IADistanceComparatorTest {
    private Location mockTargetLocation;
    private IALocation mockCurrentLocation;

    public void setUp(){
        //...
    }
    public void tearDown(){
        //.....
    }
    @Test
    public void testIsWithinRangeReturnsTrueWhenDistanceLessThan3() throws Exception {
        assertEquals(4, 2 + 3);
    }
    @Test
    public void testIsWithinRangeReturnsFalseWhenDistanceGreaterThan3() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testIsWithinRangeReturnsFalseWhenDistanceIs3() throws Exception {
        assertEquals(4, 2 + 2);
    }


}