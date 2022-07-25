package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SuperSmartParkingBoyTest {
    @Test
    public void should_park_parkingLot_higher_positionRate_with_when_park_given_a_SmartParkBoy_with_two_parkLot_and_a_car() {
        // given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLotWithSixPosition = new ParkingLot(6);//3/6
        ParkingLot parkingLotWithThreePosition = new ParkingLot(3);//1/3
        parkingLotWithThreePosition.park(new Car());
        IntStream.range(0,3).forEach(i->parkingLotWithSixPosition.park(new Car()));
        parkingLots.add(parkingLotWithThreePosition);
        parkingLots.add(parkingLotWithThreePosition);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        //excepted
        assertEquals(car,parkingLotWithThreePosition.fetch(parkingTicket));

    }
    @Test
    public void should_return_parking_ticket_when_park_given_a_SuperSmartParkBoy_and_a_car() {
        // given
        SuperSmartParkingBoy SuperSmartParkBoy = new SuperSmartParkingBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = SuperSmartParkBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_parked_car_when_fetch_given_a_SuperSmartParkBoy_with_a_parked_car_and_a_parking_ticket() {
        // given
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // then
        assertEquals(car, fetchedCar);
    }
}
