package com.thoughtworks.locker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SmartLockerRobot {
    private List<Locker> lockers = new LinkedList<Locker>();

    public SmartLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public LockerTicket store(Bag bag) {
        Collections.sort(lockers, new AvailableComparator());
        LockerTicket ticket = lockers.get(0).store(bag);
        if (null != ticket) {
            return ticket;
        }

        return null;
    }
}
