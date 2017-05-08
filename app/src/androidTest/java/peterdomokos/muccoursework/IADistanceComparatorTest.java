package peterdomokos.muccoursework;

        import android.content.Context;
        import android.location.Location;

        import android.support.test.InstrumentationRegistry;
        import android.support.test.runner.AndroidJUnit4;

        import com.indooratlas.android.sdk.IALocation;

        import org.junit.Test;
        import org.junit.runner.RunWith;

        import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertTrue;

/**
 * Created by Pete Domokos on 08/05/2017.
 */
/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class IADistanceComparatorTest {

    private IALocation mockCurrentLocation;
    private final int RANGE = 3;

    //init the mockTargetLocation
    private Location mockTargetLocation  = new Location("aProvider");

    @Test
    public void isWithinRangeReturnsTrueWhenDistanceLessThanRange() throws Exception {
        //set context
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        //set target
        mockTargetLocation.setLongitude(-0.1299845104014142);
        mockTargetLocation.setLatitude(51.52166396722949);
        //set current
        IALocation.Builder builder = new IALocation.Builder();
        IALocation.Builder bLong = builder.withLongitude(-0.1299845104014142);
        IALocation.Builder bLongAndLat = bLong.withLatitude(51.52166396722949);
        mockCurrentLocation = bLongAndLat.build();
        //check
        assertTrue(IADistanceComparator.isWithinRange(mockCurrentLocation, mockTargetLocation, RANGE));
    }
    @Test
    public void isWithinRangeReturnsFalseWhenDistanceGreaterThan3() throws Exception {
        //set context
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        //set target
        mockTargetLocation.setLongitude(-0.1299845104014142);
        mockTargetLocation.setLatitude(51.52166396722949);
        //set current
        IALocation.Builder builder = new IALocation.Builder();
        IALocation.Builder bLong = builder.withLongitude(-0.1299845104014142);
        IALocation.Builder bLongAndLat = bLong.withLatitude(30.0);
        mockCurrentLocation = bLongAndLat.build();
        //check
        assertFalse(IADistanceComparator.isWithinRange(mockCurrentLocation, mockTargetLocation, RANGE));
    }
    @Test
    public void isWithinRangeReturnsFalseWhenDistanceis3() throws Exception {
        //set context
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        //set target
        mockTargetLocation.setLongitude(-0.1299845104014142);
        mockTargetLocation.setLatitude(51.52166396722949);
        //set current
        IALocation.Builder builder = new IALocation.Builder();
        IALocation.Builder bLong = builder.withLongitude(-0.1299845104014142);
        IALocation.Builder bLongAndLat = bLong.withLatitude(51.52166396722949);
        mockCurrentLocation = bLongAndLat.build();
        //need to implement
        assertFalse(1 == 2 );
    }

}
