package com.thoughtworks.locker;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.*;

public class SmartRobotTest {

    @Test
    public void should_smartly_store_bag() throws Exception {
        List<Locker> lockers = new LinkedList<Locker>();
        Locker largeLocker = new Locker(3);
        Locker smallLocker = new Locker(2);
        lockers.add(largeLocker);
        largeLocker.store(new Bag());
        largeLocker.store(new Bag());
        lockers.add(smallLocker);

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);

        final Bag bag = new Bag();
        LockerTicket ticket = smartLockerRobot.store(bag);

        assertNull(largeLocker.pick(ticket));
        assertSame(smallLocker.pick(ticket), bag);

    }
    
    @Test
    public void should_smartly_pick_bag() throws Exception {
        
    }


}
