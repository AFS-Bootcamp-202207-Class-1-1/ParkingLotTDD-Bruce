package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author darksheep
 * @date 2022/07/24/ 21:15
 */
public class SmartParkBoy {

    private List<ParkingLot> parkingLots=new ArrayList<>();

    public SmartParkBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public SmartParkBoy() {
      this.parkingLots.add( new ParkingLot(2));
      this.parkingLots.add( new ParkingLot(3));
    }

    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }
}
