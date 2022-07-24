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
}