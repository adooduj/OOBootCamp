package com.thoughtworks.locker;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.*;

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


    @Test
    public void should_robot_store_bag() throws Exception {
        Locker locker = new Locker(10);
        LockerRobot robot = new LockerRobot(locker);

        Bag bag = new Bag();
        LockerTicket ticket = robot.store(bag);

        Bag bag1 = locker.pick(ticket);

        assertNotNull(ticket);
        assertSame(bag, bag1);
    }

    @Test
    public void should_robot_not_store_bag_when_locker_is_full() throws Exception {
        LockerRobot robot = new LockerRobot(new Locker(0));

        LockerTicket ticket = robot.store(new Bag());

        assertNull(ticket);
    }

    @Test
    public void should_robot_can_multi_lockers() throws Exception {
        List<Locker> lockers = new LinkedList<Locker>();
        final Locker locker1 = new Locker(1);
        final Locker locker2 = new Locker(1);
        lockers.add(locker1);
        lockers.add(locker2);

        LockerRobot robot = new LockerRobot(lockers);

        Bag bag = new Bag();
        LockerTicket ticket = robot.store(bag);

        Bag bag1 = locker1.pick(ticket);

        assertNotNull(ticket);
        assertSame(bag, bag1);

    }

    @Test
    public void should_robot_pick_bag_by_ticket() throws Exception {
        List<Locker> lockers = new LinkedList<Locker>();
        final Locker locker1 = new Locker(1);
        final Locker locker2 = new Locker(1);
        lockers.add(locker1);
        lockers.add(locker2);

        LockerRobot robot = new LockerRobot(lockers);

        Bag bag = new Bag();
        LockerTicket ticket = robot.store(bag);

        Bag bag1 = robot.pick(ticket);

        assertNotNull(ticket);
        assertSame(bag, bag1);
    }



}
