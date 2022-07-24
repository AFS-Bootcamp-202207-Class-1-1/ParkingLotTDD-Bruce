package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author darksheep
 * @date 2022/07/24/ 22:07
 */
class SmartParkingBoyTest {
    @Test
    public void should_return_parking_ticket_when_park_given_a_SmartParkBoy_and_a_car() {
        // given
        SmartParkingBoy SmartParkBoy = new SmartParkingBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = SmartParkBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_parked_car_when_fetch_given_a_SmartParkBoy_with_a_parked_car_and_a_parking_ticket() {
        // given
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // then
        assertEquals(car, fetchedCar);
    }
}