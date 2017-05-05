package peterdomokos.muccoursework;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.firebase.client.Firebase;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

import org.w3c.dom.Text;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Firebase mFirebase;
    Button mButton;
    List<String> mCurrentLoc = new ArrayList<>();
    TextView mLong;
    TextView mLat;
    String mTime;

    // give runtime code permissions an arbitrary value
    private final int CODE_PERMISSIONS = 1;
    //declare the manager
    IALocationManager mIALocationManager;

    //declare and instantiate the listener
    IALocationListener mIALocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation iaLocation) {
            //replace currrentLoc list items 1 and 2 ie long and lat
            if (!(mCurrentLoc.isEmpty())) {
                //note clear is optional so i can refactor later
                mCurrentLoc.clear();
            }
            mCurrentLoc.add(0, String.valueOf(iaLocation.getLongitude()));
            mCurrentLoc.add(1, String.valueOf(iaLocation.getLatitude()));
            //updateDisplay - not i will later refactor to put in separate class and pass in the loc
            updateDisplay();
        }

        ;

        @Override
        public void onStatusChanged(String str, int i, Bundle bundle) {
            //...
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

    //refactor later to pass in location
    private void updateDisplay() {
        mLong.setText(mCurrentLoc.get(0));
        mLat.setText(mCurrentLoc.get(1));
    }
    //send data to firebase database every sec
    //still need to implement a timestamp for key and then put this in onCreate and onResume????
    //sendData("new location", locationStr);

    //helper method for sending data to firebase
    private void sendData(String key, String value) {
        Firebase mFirebaseChild = mFirebase.child(key);
        mFirebaseChild.setValue(mCurrentLoc.toString());
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
        String[] neededPermissions = {
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        //request the permissions
        ActivityCompat.requestPermissions(this, neededPermissions, CODE_PERMISSIONS);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                //get current time and pass to sendData with current location every sec
                mTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                sendData(mTime, mCurrentLoc.toString());
            }
        }, 0, 1000);

    }

    //pass location updates to the manager by sending a request to listener
    protected void onResume() {
        super.onResume();
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);
    }

    //stop receiving updates when not needed
    protected void onPause() {
        super.onPause();
        mIALocationManager.removeLocationUpdates(mIALocationListener);
    }

    protected void onDestroy() {
        mIALocationManager.destroy();
        super.onDestroy();
    }

    //handle any denial of permissions
    //@Override ?????????????????
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //...must implement handling denial with a toast
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    /*public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }*.

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }

    //geofence notifications using firebase!!!!!!
}


