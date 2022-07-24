package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author darksheep
 * @date 2022/07/24/ 21:20
 */
public class StandardParkBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_a_StandardParkBoy_and_a_car() {
        // given
        StandardParkingBoy StandardParkBoy = new StandardParkingBoy();
        Car car = new Car();

        // when
        ParkingTicket parkingTicket = StandardParkBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_parked_car_when_fetch_given_a_StandardParkBoy_with_a_parked_car_and_a_parking_ticket() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        // then
        assertEquals(car, fetchedCar);
    }
    @Test
    public void should_return_right_car_with_each_ticket_when_fetch_twice_given_a_StandardParkBoy_with_two_parked_car_and_two_parking_ticket() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy();
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
    @Test
    public void should_throw_exception_with_error_message_when_fetch_given_a_StandardParkBoy_and_an_unrecognized_parking_ticket() {
        // given
        StandardParkingBoy StandardParkingBoy = new StandardParkingBoy();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        // when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> StandardParkingBoy.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    public void should_throw_exception_with_error_message_when_fetch_given_a_StandardParkBoy_and_a_used_parking_ticket() {
        // given
        StandardParkingBoy StandardParkingBoy = new StandardParkingBoy();
        ParkingTicket parkingTicket = StandardParkingBoy.park(new Car());
        StandardParkingBoy.fetch(parkingTicket);

        // when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> StandardParkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
    @Test
    public void should_throw_exception_with_error_message_when_park_given_a_StandardParkBoy_with_no_available_position_and_a_car() {
        // given
        StandardParkingBoy StandardParkingBoy = new StandardParkingBoy();
        IntStream.range(0,5).forEach(i->
                StandardParkingBoy.park(new Car())
        );
        // when & then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> StandardParkingBoy.park(new Car()));
        assertEquals("No available position.", exception.getMessage());
    }
}
