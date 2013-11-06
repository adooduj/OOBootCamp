package com.thoughtworks.locker;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

public class LockerTest {

    @Test
    public void should_store_bag_into_locker() throws Exception {
        final int capacity = 1;

        Locker locker = new Locker(capacity);

        Bag bag = new Bag();

        LockerTicket ticket = locker.store(bag);

        assertNotNull(ticket);
    }

    @Test
    public void should_not_store_bag_when_locker_is_full() throws Exception {
        final int capacity = 0;
        Locker locker = new Locker(capacity);
        Bag bag = new Bag();

        LockerTicket ticket  = locker.store(bag);

        assertNull(ticket);
    }

    @Test
    public void should_pick_bag_from_locker_by_unused_ticket() throws Exception {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        LockerTicket ticket  = locker.store(bag);
        Bag bag1 = locker.pick(ticket);

        assertSame(bag, bag1);
    }

    @Test
    public void should_not_pick_bag_from_locker_by_used_ticket() throws Exception {
        Locker locker = new Locker(1);
        Bag bag = new Bag();

        LockerTicket ticket  = locker.store(bag);
        locker.pick(ticket);
        Bag bag2 = locker.pick(ticket);

        assertNull(bag2);
    }

    @Test
    public void should_not_pick_bag_from_locker_by_fake_ticket() throws Exception {

        Locker locker = new Locker(1);
        LockerTicket fakeTicket = new LockerTicket();

        Bag bag = locker.pick(fakeTicket);

        assertNull(bag);
    }


}
