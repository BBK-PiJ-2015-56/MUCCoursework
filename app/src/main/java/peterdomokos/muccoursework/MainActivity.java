package peterdomokos.muccoursework;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mLongLabel;
    TextView mLatLabel;
    // give runtime code permissions an arbitrary value
    private final int CODE_PERMISSIONS = 1;
    //declare the manager
    IALocationManager mIALocationManager;

    //declare and instantiate the listener
    IALocationListener mIALocationListener = new IALocationListener(){
        @Override
        public void onLocationChanged(IALocation iaLocation){
            //update textview with the new location
            TextView mLongtitude = (TextView) findViewById(R.id.longtitude);
            TextView mLatitude = (TextView) findViewById(R.id.latitude);
            mLongtitude.setText(String.valueOf(iaLocation.getLongitude()));
            mLatitude.setText(String.valueOf(iaLocation.getLatitude()));
        }
        @Override
        public void onStatusChanged(String str, int i, Bundle bundle){
            //...
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLongLabel = (TextView) findViewById(R.id.long_label);
        mLatLabel = (TextView) findViewById(R.id.lat_label);

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
    }
    //pass location updates to the manager by sending a request to listener
    protected void onResume(){
        super.onResume();
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);
    }
    //stop receiving updates when not needed
    protected void onPause(){
        super.onPause();
        mIALocationManager.removeLocationUpdates(mIALocationListener);
    }
    protected void onDestroy(){
        mIALocationManager.destroy();
        super.onDestroy();
    }

    //handle any denial of permissions
    //@Override ?????????????????
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //...must implement handling denial with a toast
    }
}


