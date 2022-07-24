package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author darksheep
 * @date 2022/07/24/ 23:41
 */
public class SuperSmartBoyTest {
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
}
