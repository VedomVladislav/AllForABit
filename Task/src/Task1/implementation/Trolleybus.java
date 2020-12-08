package Task1.implementation;

import Task1.abstraction.Transport;

public class Trolleybus extends Transport{

    private final static int capacity = 30;

    public Trolleybus(String name, double price, double consumption) {
        super(name, price, consumption);
    }

    public int getCapacity() {
        return capacity;
    }

    public final void printMessageTrolleyBus() {
        System.out.println("Final method Trolleybus");
    }

}
