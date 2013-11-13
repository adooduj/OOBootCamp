package com.thoughtworks.locker;

import java.util.Comparator;

public class AvailableComparator implements Comparator<Locker> {

    @Override
    public int compare(Locker left, Locker right) {
        return (right.getCapacity() - right.getBags().size()) - (left.getCapacity() - left.getBags().size());
    }
}
