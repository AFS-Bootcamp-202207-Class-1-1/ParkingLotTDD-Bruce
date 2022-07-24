package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * @author darksheep
 * @date 2022/07/24/ 21:58
 */
public class SmartParkingBoy extends StandardParkingBoy {
    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public SmartParkingBoy() {
        super();
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = getParkingLots().stream().max(Comparator.comparingInt(ParkingLot::getEmptyPosition)).get();
        if(parkingLot.getEmptyPosition()<1)
            throw new NoAvailablePositionException();
        else
            return parkingLot.park(car);
    }
}
