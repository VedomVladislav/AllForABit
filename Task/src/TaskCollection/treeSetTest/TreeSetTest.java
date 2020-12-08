package TaskCollection.treeSetTest;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(12);
        treeSet.add(7);
        treeSet.add(3);
        treeSet.add(5);

        for (Integer i: treeSet
             ) {
            System.out.println(i);
        }


    }

}
