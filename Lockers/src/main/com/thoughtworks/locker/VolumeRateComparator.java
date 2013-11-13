package com.thoughtworks.locker;

import java.util.Comparator;

public class VolumeRateComparator implements Comparator<Locker> {

    @Override
    public int compare(Locker left, Locker right) {
        return (right.getCapacity() - right.getBags().size())/right.getCapacity() - (left.getCapacity() - left.getBags().size())/left.getCapacity();
    }
}
