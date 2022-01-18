import Maker.*;

import java.io.IOException;
import java.util.ArrayList;

public class Config {
    private static Config instance;
        private Config(){}
    public static Config getInstance(){
        if(instance == null){
            instance = new Config();
        }
        return instance;
    }
    public void config(AreaMaker make, int Rooms_Count, int Humans_Count, int Animals_Count, int Ski_count, int Bicycle_count, int Car_count) throws IOException {
        Area home = make.newHome(Rooms_Count, Humans_Count, Animals_Count, Ski_count, Bicycle_count, Car_count);

        EV ev = new EV();
        ArrayList<String> events = new ArrayList<>();
        events = ev.EV(home);
        EventReport eventReport  = new EventReport();

        eventReport.EventReport(events);
        Report report = new Report();
        report.report(home);
    }

}