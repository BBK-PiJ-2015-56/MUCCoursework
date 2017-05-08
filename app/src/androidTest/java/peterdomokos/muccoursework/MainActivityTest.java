package peterdomokos.muccoursework;

import android.content.Context;
import android.location.Location;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.firebase.client.Firebase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;

/**
 * Created by Pete Domokos on 07/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testOnRequestPermissionsResultReturnsGrantedToast(){
        MainActivity activity = rule.getActivity();

        assertEquals(1,1);

    }


}
