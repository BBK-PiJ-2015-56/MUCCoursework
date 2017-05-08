package peterdomokos.muccoursework;

import android.location.Location;
import com.indooratlas.android.sdk.IALocation;

/**
 * Created by Pete Domokos on 08/05/2017.
 */

/**
 * Has methods to compare distances between two location objects. It has method overloading to deal
 * with any combination of location objects of the IALocation and android.location types.
 */
public class IADistanceComparator {
    public static boolean isWithinRange(IALocation locationToCheck, Location target, int range){
        return locationToCheck.toLocation().distanceTo(target) < range;
    }

    //note: I could also implement teh otehr overloads of this method that deal with other
    //combinations of locations as parameters, incase someone wanted to set teh location of interest
    //using indooratlas so it would be an IALocation. However, this is not required for coursework.
}
