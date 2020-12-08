package TaskCollection.linkedListTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestCollections {

    public static void main(String[] args) {

        List<String> stringList = new LinkedList<>();
        stringList.add("Sergei");
        stringList.add("Igor");
        stringList.add("Olga");
        System.out.println("Collection: " +stringList);


        Iterator iterator = stringList.iterator();
        String first = String.valueOf(iterator.next()); //обратиться к 1 элементу
        String second = (String) iterator.next(); //обратиться ко 2 элементу
        System.out.println("First: " +first);
        System.out.println("Second: " +second);
        iterator.remove(); // удаляет элемент, к которому было последнее обращение, т.е 2-ой элемент

        System.out.println("Remove 2 el collection: " +stringList);


        ListIterator<String> listIterator = stringList.listIterator();
        String oldValue = listIterator.next();
        listIterator.set("New Sergei");

        System.out.println("Install new value on first el: " +stringList);

        System.out.println(stringList.contains("Olga")); //проверка наличия в коллекции

        System.out.println(stringList.get(0)); // не эффективен

    }

}
