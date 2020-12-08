package TaskCollection.treeSetTest;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String destination;
    private  int partNumber;

    public Item(String destination, int partNumber) {
        this.destination = destination;
        this.partNumber = partNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(destination, item.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, partNumber);
    }

    @Override
    public String toString() {
        return "{" +
                "destination='" + destination + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff :
                destination.compareTo(other.destination);
    }
}
