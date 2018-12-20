package by.psoft.hospital.hospiatal;

import java.util.LinkedList;
import java.util.Queue;

import by.psoft.hospital.family.interfaces.IFamily;
import by.psoft.hospital.hospiatal.iterator.Iterator;

public class Reception implements Iterator<IFamily> {

    private Queue<IFamily> queue;

    public Reception() {
        this.queue = new LinkedList<>();
    }

    public void acceptFamily(IFamily family) {
        System.out.println(String.format("The proj_1_hospital.hospital received %s family, %s and %s",
                family.getNationality().name().toLowerCase(), family.getWife().getName(), family.getHusband().getName()));
        queue.add(family);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public IFamily getNext() {
        return queue.poll();
    }
}
