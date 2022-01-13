package Maker;

import LivingBeing.Human;

import java.util.Random;

public class AreaMaker extends Area {
    public Area newHome(int rooms, int people, int animals){
        Area area = new Area();
        HouseMaker newHouse = new HouseMaker();
        Random rand = new Random();
        //DO FLOOR
        House house = newHouse.newHouse(rooms, people);
        area.addFloor(house);
        //DO Human
        for (int i = 0; i < people/2; i++){//v odnu komanatu jeden clovece
            area.getArea().get(0).getRooms().get(i).addHuman(new Human());
            //area.getArea().get(0).getRooms().get(i).getHumans().get(0).setWhatRoom(area.getArea().get(0).getRooms().get(0));
        }
        for (int i = 0; i<rooms; i++){
            System.out.println( "loo" + area.getArea().get(0).getRooms().get(i).getHumans());
            System.out.println( "noo" + area.getArea().get(0).getRooms().get(0).getName());

        }
        //DO TRANSPORT ROOM
        area.getTransportRoom(new House.TransportRoom());
        System.out.println("Made Maker.Area");

        return area;
    }
}
