package com.parkinglot;

/**
 * @author darksheep
 * @date 2022/07/24/ 18:51
 */
public class ParkingBoy {

    private ParkingLot parkingLot=new ParkingLot();
    public ParkingTicket park(Car car)
    {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }
}
