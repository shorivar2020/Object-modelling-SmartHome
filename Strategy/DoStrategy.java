package Strategy;

import Devices.Device;
import Event.HouseAI;
import Maker.Room;

import java.util.ArrayList;

public class DoStrategy {
    ArrayList<Device> deviceInEvents = new ArrayList<>();
    public void DoStrategy(Room r, HouseAI doing, int NumberStrategy){
        switch (NumberStrategy){
            case 1:
                doing.Day(r.getHumans(), r);
                doing.DoHotter(r.getHumans(), r);
                deviceInEvents.addAll(doing.getDeviceInEvents());
                break;
            case 2:
                doing.Day(r.getHumans(), r);
                doing.DoColder(r.getHumans(), r);
                deviceInEvents.addAll(doing.getDeviceInEvents());
                break;
            case 3:
                doing.Night(r.getHumans(), r);
                doing.DoHotter(r.getHumans(), r);
                deviceInEvents.addAll(doing.getDeviceInEvents());
                break;
            case 4:
                doing.Night(r.getHumans(), r);
                doing.DoColder(r.getHumans(), r);
                deviceInEvents.addAll(doing.getDeviceInEvents());
                break;
            case 0:
                break;
        }
    }
    public ArrayList<Device> getDeviceInEvents(){
        return deviceInEvents;
    }
}
