package peterdomokos.muccoursework;

import com.firebase.client.Firebase;
import com.indooratlas.android.sdk.IALocation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pete Domokos on 08/05/2017.
 */

/**
 * a class for another context to use to communicate with a given Firebase database
 */
public class FirebaseCommunicator {
    private Firebase firebase;

    /**
     * Constructor method
     * @param afirebase: the firebase object that will contains the link to the database
     */
    public FirebaseCommunicator(Firebase afirebase){
        firebase = afirebase;
    }

    /**
     * a method that sends a formatted string repn of the location to the database,
     * by creating a child in the database.
     * @param time: a timestamp that will be used as the key for the database child
     * @param location: the location object from which the longtitude, latitude and floor level
     *                will be extracted and sent as a String for the value of the database child
     */
    public void sendData(SimpleDateFormat time, IALocation location) {
        //put Time(ie key) into correct format for firebase
        String formattedTime = time.format(new Date()).replace('.', ':');
        Firebase firebaseChild = firebase.child(formattedTime);
        firebaseChild.setValue(formatLocationForFirebase(location));
    }

    /**
     * A method which converts an IALocation object into a String repn of the longtitude, latitude and floor level.
     * @param location: The location to be converted
     * @return the string containing the locations longtitude, latitude and floor level only.
     */
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
