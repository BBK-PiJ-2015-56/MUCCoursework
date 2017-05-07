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

    Firebase mFirebase;
    Button mButton;
    IALocation mCurrentLoc;
    String mcurrentLongStr ="no value yet";
    String mcurrentLatStr = "no value yet";
    String mCurrentFloorStr = "no value yet";
    TextView mLong;
    TextView mLat;
    String mTime ="";
    Timer t;
    Location mLocOfInterest;
    int withinRangeToastID = 0;
    String permissionRequestToast = "";
    String finalPermissionToast = "";

    // give runtime code permissions an arbitrary value
    private final int PERMISSIONS_REQUEST_CODE = 1;
    //declare the manager
    IALocationManager mIALocationManager;

    //declare and instantiate the listener
    IALocationListener mIALocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation iaLocation) {
            mCurrentLoc = iaLocation;
            mcurrentLongStr = String.valueOf(mCurrentLoc.getLongitude());
            mcurrentLatStr = String.valueOf(mCurrentLoc.getLatitude());
            mCurrentFloorStr = String.valueOf(mCurrentLoc.getFloorLevel());

            Log.i("info", "CURRENT LOCATION CHANGED TO " + mCurrentLoc.toString());
            updateDisplay();
        }

        @Override
        public void onStatusChanged(String str, int i, Bundle bundle) {
            //...
        }
    };

    //refactor later to pass in location
    private void updateDisplay() {
        mLong.setText(mcurrentLongStr);
        mLat.setText(mcurrentLatStr);
        // toast if within fence
        if(mCurrentLoc.toLocation().distanceTo(mLocOfInterest) < 3.0) {
            withinRangeToastID = R.string.within_range_toast;
            Toast.makeText(this, withinRangeToastID, Toast.LENGTH_SHORT).show();
        }
    }

    //helper method for sending data to firebase
    private void sendData() {
        mTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.i("info", "mTime declared as..." + mTime );
        //put key into correct format for firebase
        String formattedTime = mTime.replace('.', ':');
        Firebase mFirebaseChild = mFirebase.child(formattedTime);
        mFirebaseChild.setValue("[" +mcurrentLongStr +" , " +mcurrentLatStr +" , " +mCurrentFloorStr +"]");
        Log.i("info", "value of child set!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wire up two TextViews for location coods
        mLong = (TextView) findViewById(R.id.long_value);
        mLat = (TextView) findViewById(R.id.lat_value);
        //wire up our test button for firebase
        mButton = (Button) findViewById(R.id.send_data);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a child of mFirebase and add a value to test firebase works
                //Firebase mFirebaseChild = mFirebase.child("button press");
                //mFirebaseChild.setValue("send data button");
                //it works but only first click - use push() and then key will be a uniqueID
                mFirebase.push().setValue("button pressed");
                //this works but key name is not in our control
                //may be better to wire up a timestamp and that can be the key and the value will be the long and lat as an array
                //for testing, I will retrieve data too
            }
        });
        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://muccoursework-a1c7e.firebaseio.com/");

        //instantiate location manager, passing in current context
        mIALocationManager = IALocationManager.create(this);

        //ask for permissions at run time
        //// TODO: 06/05/2017 check i really need any of the permissions i added later 
        String[] neededPermissions = {
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
        };

        //request the permissions
        ActivityCompat.requestPermissions(this, neededPermissions, PERMISSIONS_REQUEST_CODE);

        //set location of interest - wire up to UI later!!!!!!
        //// TODO: 06/05/2017 wire up loc of interest with UI 
        mLocOfInterest = new Location("aProvider");
        mLocOfInterest.setLongitude(-0.1299845104014142);
        mLocOfInterest.setLatitude(51.52166396722949);
    }

    //deal with permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        int permissionToastID = 0;
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
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                sendData();
                Log.i("info", "data sent to firebase");
            }
        }, 2000, 1000);
        //WARNING: I must cancel in onPause
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);

    }

    //stop receiving updates when not needed
    protected void onPause() {
        super.onPause();
        //cancel the timer
        t.cancel();
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




