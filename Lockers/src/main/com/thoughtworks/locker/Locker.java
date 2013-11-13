package com.thoughtworks.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int capacity;
    private Map<LockerTicket, Bag> bags = new HashMap<LockerTicket, Bag>();

    public int getCapacity() {
        return capacity;
    }

    public Map<LockerTicket, Bag> getBags() {
        return bags;
    }

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public LockerTicket store(Bag bag) {
        LockerTicket lockerTicket = new LockerTicket();

        bags.put(lockerTicket, bag);

        return capacity - bags.size() >= 0 ? lockerTicket : null;
    }

    public Bag pick(LockerTicket ticket) {

        Bag remove = bags.remove(ticket);
        return remove;
    }

}
