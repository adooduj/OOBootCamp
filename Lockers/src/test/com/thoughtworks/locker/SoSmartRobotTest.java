package com.thoughtworks.locker;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

public class SoSmartRobotTest {

    @Test
    public void should_smartly_store_bag() throws Exception {
        List<Locker> lockers = new LinkedList<Locker>();
        Locker largeLocker = new Locker(10);
        Locker smallLocker = new Locker(10);
        lockers.add(largeLocker);
        largeLocker.store(new Bag());
        largeLocker.store(new Bag());
        lockers.add(smallLocker);

        SoSmartLockerRobot smartLockerRobot = new SoSmartLockerRobot(lockers);

        final Bag bag = new Bag();
        LockerTicket ticket = smartLockerRobot.store(bag);

        assertNull(largeLocker.pick(ticket));
        assertSame(smallLocker.pick(ticket), bag);

    }

}
