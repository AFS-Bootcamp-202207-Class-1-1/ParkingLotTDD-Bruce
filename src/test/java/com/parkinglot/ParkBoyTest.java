package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author darksheep
 * @date 2022/07/24/ 18:58
 */
public class ParkBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_parkinglotBoy_and_a_car() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }
}
