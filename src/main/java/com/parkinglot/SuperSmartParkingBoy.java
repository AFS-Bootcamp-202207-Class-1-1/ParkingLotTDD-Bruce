package com.parkinglot;

import java.util.Comparator;

/**
 * @author darksheep
 * @date 2022/07/24/ 23:41
 */
public class SuperSmartParkingBoy extends StandardParkingBoy {
    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = getParkingLots().stream().max(Comparator.comparingDouble(ParkingLot::getPositionRate)).get();
        if(parkingLot.getEmptyPosition()<1)
            throw new NoAvailablePositionException();
        else
            return parkingLot.park(car);
    }
}
