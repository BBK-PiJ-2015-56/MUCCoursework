package peterdomokos.muccoursework;

import android.location.Location;
import com.indooratlas.android.sdk.IALocation;

/**
 * Created by Pete Domokos on 08/05/2017.
 */

/**
 *A utility class for comparing locations. It has methods to compare distances between two location objects. It has method overloading to deal
 * with any combination of location objects of the IALocation and android.location types.
 */
public class IADistanceComparator {

    /**
     * A method for comparing a location of type IAlocation with a target location of type android.location
     * to see if the location is within a given distance from the target
     * @param locationToCheck: the IALocation object that is to eb compared against the target
     * @param target: the android location object that is the target location
     * @param range: the distance from the target that the location must be within for the method to return true
     *
     *@return true if location is within the range of the target, false otherwise
     *
     */
    public static boolean isWithinRange(IALocation locationToCheck, Location target, int range){
        return locationToCheck.toLocation().distanceTo(target) < range;
    }

    //note: I could also implement the other overloads of this method that deal with other
    //combinations of locations as parameters, incase someone wanted to set the location of interest
    //using indooratlas so it would be an IALocation. However, this is not required for coursework.
}
