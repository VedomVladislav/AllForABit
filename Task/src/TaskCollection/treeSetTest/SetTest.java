package TaskCollection.treeSetTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<String> words = new HashSet<>();

        long totalTime = 0;

        try (Scanner sc = new Scanner(System.in))
        {
            while (sc.hasNext()) {
                String word = sc.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 0; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
            System.out.println("...");
            System.out.println(words.size() + " distinct words " + totalTime + " milliseconds.");
        }

        Set<String> listHashSet = new HashSet<>();
        listHashSet.add("Vlad");
        listHashSet.add("vlad");
        listHashSet.add("VLAD");
        listHashSet.add("vlad");
        listHashSet.add("Vlad");


        System.out.println(listHashSet);
    }

}
