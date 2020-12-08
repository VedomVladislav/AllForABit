package Task1.implementation;

import Task1.abstraction.Transport;

public class Minibus extends Transport {

    private final static int capacity = 12;

    public Minibus(String name, double price, double consumption) {
        super(name, price, consumption);
    }

    public int getCapacity() {
        return capacity;
    }

    public void printMessageMinibus() {
        System.out.println("Final method Minibus");
    }
}
