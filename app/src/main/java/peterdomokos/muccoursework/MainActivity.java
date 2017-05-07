package peterdomokos.muccoursework;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Firebase mFirebase;
    private IALocation mCurrentLoc;

    private TextView mLong;
    private TextView mLat;
    private Timer mTimer;
    private Location mLocOfInterest;

    // give runtime code permissions an arbitrary value
    private final int PERMISSIONS_REQUEST_CODE = 1;
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
            //...
        }
    };

    //refactor later to pass in location
    private void updateDisplay() {
        mLong.setText(String.valueOf(mCurrentLoc.getLongitude()));
        mLat.setText(String.valueOf(mCurrentLoc.getLatitude()));
        // toast if within fence
        if(mCurrentLoc.toLocation().distanceTo(mLocOfInterest) < 3.0)
            Toast.makeText(this, R.string.within_range_toast, Toast.LENGTH_SHORT).show();
    }
    ///////////////
    //////////////
    ///////////////
    //helper method for sending data to firebase
    private void sendData(SimpleDateFormat time, IALocation location) {
        //put Time(ie key) into correct format for firebase
        String formattedTime = time.format(new Date()).replace('.', ':');
        Firebase mFirebaseChild = mFirebase.child(formattedTime);
        mFirebaseChild.setValue(formatLocation(location));
    }

    private String formatLocation(IALocation location) {
        if(location == null)
            return "[" + "no location yet" +"]";
        else {
            String longStr = String.valueOf(location.getLongitude());
            String latStr = String.valueOf(location.getLatitude());
            String floorStr = String.valueOf(location.getFloorLevel());
            return "[" + longStr + " , " + latStr + " , " + floorStr + "]";
        }
    }
    /////////////////
    //////////////////
    /////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wire up two TextViews for location coods
        mLong = (TextView) findViewById(R.id.long_value);
        mLat = (TextView) findViewById(R.id.lat_value);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://muccoursework-a1c7e.firebaseio.com/");

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

        // TODO: 06/05/2017 wire up loc of interest with UI
        mLocOfInterest = new Location("aProvider");
        mLocOfInterest.setLongitude(-0.1299845104014142);
        mLocOfInterest.setLatitude(51.52166396722949);
    }

    //deal with permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        int permissionToastID = 0;
        String permissionRequestToast = "";
        String finalPermissionToast = "";
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

    //pass location updates to the manager by sending a request to listener
    protected void onResume() {
        super.onResume();
        //set timer for sending data to firebase - this way it will send to database every second regardless
        //of whether or not the location changes
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendData(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"), mCurrentLoc);
            }
        }, 2000, 1000);
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);

    }

    protected void onPause() {
        super.onPause();
        //cancel the timer
        mTimer.cancel();
        //stop receiving updates when not needed
        mIALocationManager.removeLocationUpdates(mIALocationListener);
        Log.i("info", "timer and loc updates cancelled!!!!!!!!!!!!!!!!");
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





