package com.thoughtworks.locker;

import java.util.LinkedList;
import java.util.List;

public class LockerRobot {

    private List<Locker> lockers = new LinkedList<Locker>();

    public LockerRobot(Locker locker) {
        lockers.add(locker);
    }

    public LockerRobot(List<Locker> lockers) {
        this.lockers.addAll(lockers);
    }

    public LockerTicket store(Bag bag) {

        for (Locker locker : lockers) {
            LockerTicket ticket = locker.store(bag);
            if (null != ticket) {
                return ticket;
            }
        }

        return null;
    }

    public Bag pick(LockerTicket ticket) {
        for (Locker locker : lockers) {
            Bag bag = locker.pick(ticket);
            if (null != bag) {
                return bag;
            }
        }

        return null;
    }
}
