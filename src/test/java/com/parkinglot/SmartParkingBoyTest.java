package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author darksheep
 * @date 2022/07/24/ 21:20
 */
public class SmartParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_smartParkingBoy_and_a_car() {
        // given
        SmartParkBoy smartParkingBoy = new SmartParkBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = smartParkingBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_parked_car_when_fetch_given_a_smartParkingBoy_with_a_parked_car_and_a_parking_ticket() {
        // given
        SmartParkBoy parkingBoy = new SmartParkBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // then
        assertEquals(car, fetchedCar);
    }
    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_twice_given_a_SmartParkingBoy_with_two_parked_car_and_two_parking_ticket() {
        // given
        SmartParkBoy parkingBoy = new SmartParkBoy();
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
