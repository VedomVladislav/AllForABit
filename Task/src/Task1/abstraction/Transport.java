package Task1.abstraction;

import Task1.exeptions.MyOwnExeption;

public abstract class Transport extends MyOwnExeption {

    private String name;
    private double price;
    private double consumption;
    private int countPeople;
    private int capacity;

    public Transport(String name, double price, double consumption) {
        super();
        this.name = name;
        this.price = price;
        this.consumption = consumption;
        this.countPeople = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", consumption=" + consumption +
                ", countPeople=" + countPeople +
                '}';
    }

    public final void inPeople(int people) {
        countPeople += people;
    }

    public final void outPeople(int people) {
        countPeople -= people;
    }

    public final void printMessage() {
        System.out.println("Final method TRANSPORT");
    }

}
