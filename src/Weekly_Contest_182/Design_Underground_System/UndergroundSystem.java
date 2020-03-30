package Weekly_Contest_182.Design_Underground_System;

import java.util.HashMap;

class TimeStatistic {
    int timeSum = 0;
    int frequency = 0;
}

class Rider {
    String enterStationName;
    int enterTime;

    Rider(String n, int t) {
        enterStationName = n;
        enterTime = t;
    }
}

public class UndergroundSystem {
    HashMap<Integer, TimeStatistic> hashMap = new HashMap<>();
    HashMap<Integer, Rider> riders = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        riders.put(id, new Rider(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Rider rider = riders.remove(id);
        int key = rider.enterStationName.hashCode() * 31 + stationName.hashCode();
        TimeStatistic ts = hashMap.get(key);
        if (ts == null) ts = new TimeStatistic();
        ts.timeSum += t - rider.enterTime;
        ts.frequency++;
        hashMap.put(key, ts);
    }

    public double getAverageTime(String startStation, String endStation) {
        TimeStatistic ts = hashMap.get(startStation.hashCode() * 31 + endStation.hashCode());
        return (double) ts.timeSum / ts.frequency;
    }
}
