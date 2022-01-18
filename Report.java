import Devices.Device;
import LivingBeing.Animal;
import LivingBeing.Human;
import Maker.Area;
import Maker.House;
import Maker.Parking;
import Maker.Room;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
    public void report(Area home) throws IOException {
        File file = new File("C:\\Users\\User\\omo-smart-home\\Reports", "ConsumptionReport.txt.txt");
        FileWriter writer = new FileWriter(file, false);
        int totalElectricity = 0;
        int totalWater = 0;
        int totalMoney = 0;
        for(House h: home.getArea()){
            for (Room r: h.getRooms()){
                for(Device d: r.getDevices()){
                    writer.write(" -" + d);
                    writer.write("| Electricity:" + d.getElectricity());
                    writer.write("| Water:" + d.getWater());
                    writer.write("| Money:" + d.getMoney());
                    writer.append("\n");
                    totalElectricity += d.getElectricity();
                    totalWater += d.getWater();
                    totalMoney += d.getMoney();
                }
            }
        }
        writer.append("\n");
        writer.write("totalElectricity: " + totalElectricity);
        writer.write("| totalWater: " + totalWater);
        writer.write("| TotalMoney: " + totalMoney);
        writer.flush();
        File file1 = new File("C:\\Users\\User\\omo-smart-home\\Reports", "HouseConfigurationReport.txt");
        File file2 = new File("C:\\Users\\User\\omo-smart-home\\Reports", "HouseConfigurationReportDevice.txt");
        FileWriter writHome = new FileWriter(file1, false);
        FileWriter writDevices = new FileWriter(file2, false);
        writHome.write("| Home: " + home);
        writHome.append('\n');
        writHome.write("| Area: " + home.getArea());
        writHome.append('\n');
        for (House f : home.getArea()){
            writHome.write("| House:" + f);
            writHome.append('\n');
            writHome.write("| Transport room:" + f.getTrRooms());
            writHome.append('\n');
            writHome.write("| Rooms: " + f.getRooms());
            writHome.append('\n');
            for (Room r : f.getRooms()){
                writHome.write("| Room: " + r);
                writHome.append('\n');
                writHome.write("| Type: " + r.getName());
                writHome.append('\n');
                writHome.write("| Devices: " + r.getDevices());
                writHome.append('\n');
                writHome.write("| Humans: " + r.getHumans());
                writHome.append('\n');
                for(Device d : r.getDevices()){
                    writDevices.write("| Device: " + d);
                    writDevices.append('\n');
                    writDevices.write("| Type: " + d.getDeviceName());
                    writDevices.append('\n');
                    if(d.getUsers().contains(null)){
                        writDevices.write("| Users: AI HOME");
                    }
                    else{
                        writDevices.write("| Users: " + d.getUsers());
                    }
                    writDevices.append('\n');
                    writDevices.write(" | Electricity: " + d.getElectricity());
                    writDevices.append('\n');
                    writDevices.write("| Water: " + d.getWater());
                    writDevices.append('\n');
                    writDevices.write("| Money: " + d.getMoney());
                    writDevices.append('\n');
                }
            }
        }
        writDevices.flush();
        writHome.flush();
        File file3 = new File("C:\\Users\\User\\omo-smart-home\\Reports", "ActivityAndUsageReport.txt");
        FileWriter writHuman = new FileWriter(file3, false);
        for(House h: home.getArea()) {
            for (Room r : h.getRooms()) {
                for (Human p : r.getHumans()) {
                    writHuman.write(String.valueOf(p));
                    writHuman.append('\n');
                    writHuman.write("Transport:" + p.getUseTransport());
                    writHuman.append('\n');
                    writHuman.write("Devices:" + p.getUse());
                    writHuman.append('\n');
                    writHuman.write("Do:" + p.getDoings());
                    writHuman.append('\n');
                    writHuman.write("Animal:" + p.getWithAnimal());
                    writHuman.append('\n');
                }
                for (Animal a: r.getAnimals()){
                    writHuman.write(String.valueOf(a));
                    writHuman.append('\n');
                    writHuman.write("Humans:" + a.getWithHuman());
                    writHuman.append('\n');
                }
            }
            for (Parking t : h.getTrRooms()) {
                for (Human p : t.getHumans()) {
                    writHuman.write(String.valueOf(p));
                    writHuman.append('\n');
                    writHuman.write("Transport:" + p.getUseTransport());
                    writHuman.append('\n');
                    writHuman.write("Devices:" + p.getUse());
                    writHuman.append('\n');
                    writHuman.write("Do:" + p.getDoings());
                    writHuman.append('\n');
                    writHuman.write("Animal:" + p.getWithAnimal());
                    writHuman.append('\n');
                }
            }
            writHuman.flush();
        }
    }
}
