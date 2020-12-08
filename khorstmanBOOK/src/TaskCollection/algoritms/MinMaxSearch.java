package TaskCollection.algoritms;

import Task3.beans.Employee;

import java.util.*;

public class MinMaxSearch <T extends Comparable> {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(4);
        list.add(11);
        list.add(77);
        list.add(2);
        list.add(33);

        searchMax(list);


    }

    public static <T extends  Comparable> void searchMax(List<T> l) {

        if (l.isEmpty()) throw new NoSuchElementException();

        Iterator<T> iterator = l.iterator();
        T maxElement = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if(maxElement.compareTo(next) < 0) maxElement = next;
        }

        System.out.println(maxElement);

    }

}
