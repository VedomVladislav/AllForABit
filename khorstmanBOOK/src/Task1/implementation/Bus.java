package Task1.implementation;

import Task1.abstraction.Transport;

public class Bus extends Transport {

    private final static int capacity = 20;

    public Bus(String name, double price, double consumption) {
        super(name, price, consumption);
    }

    public int getCapacity() {
        return capacity;
    }

    public void printMessageBUS() {
        System.out.println("Final method BUS");
    }

}
