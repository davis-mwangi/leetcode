package Neetcode_450_Questions;

/*

https://leetcode.com/problems/design-parking-system/description/

*/
import java.util.*;

public class DesignParkingSystem_Easy_LC1603 {
    /*
     * 1 - big
     * 2 - medium
     * 3 - small
     */
    class ParkingSystem {
        Map<Integer, Integer> parking = new HashMap<>();

        public ParkingSystem(int big, int medium, int small) {
            this.parking.put(1, big);
            this.parking.put(2, medium);
            this.parking.put(3, small);
        }

        public boolean addCar(int carType) {
            if (parking.get(carType) > 0) {
                parking.put(carType, parking.get(carType) - 1);
                return true;
            }
            return false;
        }
    }
}
