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

            ParkingTicket parkingTicket=null;
            for (int i=0;i<parkingLots.size();i++) {
                try{
                   parkingTicket= parkingLots.get(i).park(car);
                }
                catch (NoAvailablePositionException e)
                {
                    if(i==parkingLots.size()-1)
                        throw e;
                }
                finally {
                    if(parkingTicket!=null)
                        return parkingTicket;
                }
            }
            return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car=null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                car=parkingLot.fetch(parkingTicket);
            }
            catch (UnrecognizedParkingTicketException e)
            { }
            if(car!=null)
                break;
        }
        if(car!=null)
            return car;
        else throw new UnrecognizedParkingTicketException();
    }
}
