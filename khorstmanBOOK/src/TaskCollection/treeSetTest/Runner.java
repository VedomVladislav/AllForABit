package TaskCollection.treeSetTest;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Runner {

    public static void main(String[] args) {

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Modem",9912));
        System.out.println(parts.toString());

        NavigableSet<Item> sortByDestination = new TreeSet<>(
                Comparator.comparing(Item::getDestination)
        );
        sortByDestination.addAll(parts);
        System.out.println(sortByDestination.toString());

    }

}
