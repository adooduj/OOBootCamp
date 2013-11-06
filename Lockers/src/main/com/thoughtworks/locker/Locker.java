package com.thoughtworks.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private int capacity;
    private Map<LockerTicket, Bag> bags = new HashMap<LockerTicket, Bag>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public LockerTicket store(Bag bag) {

        LockerTicket lockerTicket = new LockerTicket();
        bags.put(lockerTicket, bag);

        return bags.size()<= this.capacity ? lockerTicket : null;
    }

    public Bag pick(LockerTicket ticket) {
        return bags.remove(ticket);
    }
}
