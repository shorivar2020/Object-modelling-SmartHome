package Maker;

import LivingBeing.Human;

public class HouseMaker {
    public House newHouse(int rooms, int people) {
        House house = new House();
        for (int i = 0; i < rooms; i++) {
            RoomMaker room = new RoomMaker();
            house.setRoom(room.newRoom());
        }


        System.out.println("Made Maker.House with Rooms");
        return house;
    }
}