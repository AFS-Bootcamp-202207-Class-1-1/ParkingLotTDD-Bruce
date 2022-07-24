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
    public void should_return_parking_ticket_when_park_given_a_parkingBoy_and_a_car() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_parked_car_when_fetch_given_a_parkingBoy_with_a_parked_car_and_a_parking_ticket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // then
        assertEquals(car, fetchedCar);
    }
    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_twice_given_a_parkingBoy_with_two_parked_car_and_two_parking_ticket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carA = new Car();
        Car carB = new Car();
        ParkingTicket parkingTicketA = parkingBoy.park(carA);
        ParkingTicket parkingTicketB = parkingBoy.park(carB);

        // when
        Car firstFetchedCar = parkingBoy.fetch(parkingTicketA);
        Car secondFetchedCar = parkingBoy.fetch(parkingTicketB);

        // then
        assertEquals(carA, firstFetchedCar);
        assertEquals(carB, secondFetchedCar);
    }
}
