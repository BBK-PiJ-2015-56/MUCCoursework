package peterdomokos.muccoursework;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;


import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * An activity which sets up a channel to start receiving IALocation updates. It displays the current location
 * on the display, sends location updates to a database every second, and sends a toast whenever the location is within
 * a given range of a specific location.
 */
public class MainActivity extends AppCompatActivity {

    private Firebase mFirebase;
    private FirebaseCommunicator mFirebaseCommunicator;
    private IALocation mCurrentLoc;

    private TextView mLong;
    private TextView mLat;
    private Timer mTimer;
    private Location mLocOfInterest;

    // give runtime code permissions an arbitrary value
    private final int PERMISSIONS_REQUEST_CODE = 1;
    //geo fence range
    private final int GEOFENCE_RANGE = 3;
    //declare the manager
    IALocationManager mIALocationManager;

    //declare and instantiate the listener
    IALocationListener mIALocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation iaLocation) {
            mCurrentLoc = iaLocation;
            updateDisplay();
        }

        @Override
        public void onStatusChanged(String str, int i, Bundle bundle) {
            //not required
        }
    };

    /**
     * A method which updates the longtitude and latitude displayed on screen with the current position,
     * and displays a toast if that position is within the range of the location of interest.
     *
     */
    private void updateDisplay() {
        mLong.setText(String.valueOf(mCurrentLoc.getLongitude()));
        mLat.setText(String.valueOf(mCurrentLoc.getLatitude()));
        // toast if within fence
        if(IADistanceComparator.isWithinRange(mCurrentLoc, mLocOfInterest, GEOFENCE_RANGE))
            Toast.makeText(this, R.string.within_range_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wire up two TextViews for location coods
        mLong = (TextView) findViewById(R.id.long_value);
        mLat = (TextView) findViewById(R.id.lat_value);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://muccoursework-a1c7e.firebaseio.com/");
        mFirebaseCommunicator = new FirebaseCommunicator(mFirebase);
        //instantiate location manager, passing in current context
        mIALocationManager = IALocationManager.create(this);

        //ask for permissions at run time
        String[] neededPermissions = {
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
        };

        //request the permissions
        ActivityCompat.requestPermissions(this, neededPermissions, PERMISSIONS_REQUEST_CODE);

        //initialize the location of interest
        mLocOfInterest = new Location("aProvider");
        mLocOfInterest.setLongitude(-0.1299845104014142);
        mLocOfInterest.setLatitude(51.52166396722949);
    }

    //deal with permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        int permissionToastID;
        String permissionRequestToast;
        String finalPermissionToast;
        for (int i = 0; i < grantResults.length; i++){
            permissionRequestToast = "Requested: " +permissions[i] + "...";
            if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                Log.i("info", "permission granted for: " + permissions[i]);
                permissionToastID = R.string.permission_granted_toast;
            }else{
                Log.i("info", "permission denied for: " + permissions[i]);
                permissionToastID = R.string.permission_denied_toast;
            }
            finalPermissionToast = permissionRequestToast + getString(permissionToastID);
            Toast.makeText(this, finalPermissionToast , Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Sets a timertask which will send location data to a database every second.
     * It also starts the location updates requests, and calls its super.
     */
    protected void onResume() {
        super.onResume();
        //set timer for sending data to firebase - this way it will send to database every second regardless
        //of whether or not the location changes
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mFirebaseCommunicator.sendData(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"), mCurrentLoc);
            }
        }, 2000, 1000);
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);

    }

    /**
     * cancels the timertask which is sending teh location updates to teh database,
     * and also removes the location updates that are being received through location listener.
     */
    protected void onPause() {
        super.onPause();
        //cancel the timer
        mTimer.cancel();
        //stop receiving updates when not needed
        mIALocationManager.removeLocationUpdates(mIALocationListener);
    }

    protected void onDestroy() {
        mIALocationManager.destroy();
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


}





