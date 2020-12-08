package TaskCollection.linkedListTest;

import java.util.*;

public class LinkedListTest {

    public static void main(String[] args) {

        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Douge");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //delete every 2 word at b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip first element
            if (bIter.hasNext()) {
                bIter.next(); // next element
                bIter.remove(); // delete this element
            }
        }

        System.out.println(b);

        // group operation deleting in a
        // all world which b is consist
        a.removeAll(b);

        System.out.println(a);

    }
}
