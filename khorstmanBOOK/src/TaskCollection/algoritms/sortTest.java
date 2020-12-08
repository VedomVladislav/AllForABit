package TaskCollection.algoritms;

import Task3.beans.Employee;

import java.util.*;
import java.util.function.Predicate;

public class sortTest {

    public static void main(String[] args) {

        List<Employee> sortedList = new LinkedList<>(); // Аналог var sortedList = new LinkedList<>();
        sortedList.add(new Employee("Vlad", 24,"Serdicha 76-37"));
        sortedList.add(new Employee("Alex", 23,"Pobeditelei 13"));
        sortedList.add(new Employee("Sergei", 20,"Senica 80-9"));

        Collections.shuffle(sortedList);

        sortedList.sort(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName).reversed());

        System.out.println(sortedList.toString());


//        var listTest = new ArrayList<String>();
//        listTest.add("World");
//        listTest.add("Long");
//        listTest.add("String");
//        listTest.add("Hello");
//        listTest.add("Sample");
//        listTest.add("Hello");
//
//        System.out.println(listTest);
//
//        Collections.replaceAll(listTest,"Hello", "66"); //замена всех "Hello" на 66
//
//        listTest.removeIf(e -> e.length() <= 4);
//        listTest.replaceAll(String::toLowerCase);
//
//        Collections.sort(listTest);
//        System.out.println(listTest);
//
//        System.out.println(Collections.max(listTest));
//
//
//        var result = new HashSet<>(sortedList);
//        System.out.println(result);
//        result.retainAll(listTest); //удаляет из result все, что ОТСУТСТВУЕТ в listTest
//        System.out.println(result);


    }

}
