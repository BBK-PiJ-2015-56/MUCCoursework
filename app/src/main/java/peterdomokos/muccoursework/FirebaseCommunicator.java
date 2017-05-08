package peterdomokos.muccoursework;

import com.firebase.client.Firebase;
import com.indooratlas.android.sdk.IALocation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pete Domokos on 08/05/2017.
 */

public class FirebaseCommunicator {
    private Firebase firebase;

    public FirebaseCommunicator(Firebase afirebase){
        firebase = afirebase;
    }

    public void sendData(SimpleDateFormat time, IALocation location) {
        //put Time(ie key) into correct format for firebase
        String formattedTime = time.format(new Date()).replace('.', ':');
        Firebase firebaseChild = firebase.child(formattedTime);
        firebaseChild.setValue(formatLocationForFirebase(location));
    }

    public String formatLocationForFirebase(IALocation location) {
         if(location == null)
             return "[" + "no location yet" +"]";
         else {
             String longStr = String.valueOf(location.getLongitude());
             String latStr = String.valueOf(location.getLatitude());
             String floorStr = String.valueOf(location.getFloorLevel());
             return "[" + longStr + " , " + latStr + " , " + floorStr + "]";
         }
    }
}
