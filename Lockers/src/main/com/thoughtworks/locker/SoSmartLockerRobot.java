package com.thoughtworks.locker;

import java.util.Collections;
import java.util.List;

public class SoSmartLockerRobot {
    private final List<Locker> lockers;

    public SoSmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public LockerTicket store(Bag bag) {
        Collections.sort(lockers, new VolumeRateComparator());
        LockerTicket ticket = lockers.get(0).store(bag);
        if (null != ticket) {
            return ticket;
        }
        return null;

    }
}
