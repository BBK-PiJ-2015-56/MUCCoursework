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
    public static boolean isWithinRangeOfTarget(IALocation locationToCheck, Location target, int range){
        return locationToCheck.toLocation().distanceTo(target) < range;
    }
}
