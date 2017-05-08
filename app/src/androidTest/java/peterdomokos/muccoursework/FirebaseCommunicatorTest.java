package peterdomokos.muccoursework;

/**
 * Created by Pete Domokos on 08/05/2017.
 */

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.firebase.client.Firebase;
import com.indooratlas.android.sdk.IALocation;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FirebaseCommunicatorTest {
    private IALocation mockCurrentLocation;
    private Firebase firebase;
    private FirebaseCommunicator firebaseCommunicator;

    @Test
    public void formatLocationForFirebaseGivesDefaultMessageWhenNull(){
        //set context
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        //init firebase
        Firebase.setAndroidContext(appContext);
        firebase = new Firebase("https://muccoursework-a1c7e.firebaseio.com/");
        firebaseCommunicator = new FirebaseCommunicator(firebase);
        //we do not init mock loaction in this test
        String expected = "[" + "no location yet" +"]";
        String actual = firebaseCommunicator.formatLocationForFirebase(mockCurrentLocation);
        assertEquals(expected, actual);
    }
    @Test
    public void formatLocationForFirebaseGivesLongLatAndFloorString(){
        //set context
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        //init firebase
        Firebase.setAndroidContext(appContext);
        firebase = new Firebase("https://muccoursework-a1c7e.firebaseio.com/");
        firebaseCommunicator = new FirebaseCommunicator(firebase);

        //init location
        IALocation.Builder builder = new IALocation.Builder();
        IALocation.Builder bLong = builder.withLongitude(-0.1);
        IALocation.Builder bLongAndLat = bLong.withLatitude(51.0);
        IALocation.Builder bLongLatAndFloor = bLongAndLat.withFloorLevel(4);
        mockCurrentLocation = bLongAndLat.build();

        String expected = "[" + -0.1 + " , " + 51.0 + " , " + 4 + "]";
        String actual = firebaseCommunicator.formatLocationForFirebase(mockCurrentLocation);
        assertEquals(expected, actual);

    }
}
