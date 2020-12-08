package Task4.lambdas;

import Task3.beans.Employee;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

public class LambdasRunner {

    public static void main(String[] args) {

        String[] planets = new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted planets: ");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length: ");
        Arrays.sort(planets,
                (first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //functional interfaces
        BiFunction<String, String, Integer> comp =
                (first,second) -> first.length() - second.length();

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(null);
        list.add(22);
        list.add(10);
        list.add(3);

        System.out.println("\n" + list);
        list.removeIf(e -> e == null); //work with functional interface Predicate
        System.out.println(list);

        TimedGreeter timedGreeter = new TimedGreeter();
        timedGreeter.greet();

        Employee[] listEmployees = new Employee[3];
        listEmployees[0] = new Employee("Vlad",40,"Tver");
        listEmployees[1] = new Employee("Kirill",36,"Riga");
        listEmployees[2] = new Employee("Polina",66,"Vitebsk");
        System.out.println("Исходный массив: ");
        for (int i = 0; i < listEmployees.length; i++) {
            System.out.println("a["+i+"]=" +listEmployees[i]);
        }
        Arrays.sort(listEmployees,
                    Comparator.comparing(Employee::getName)
                    .thenComparing(Employee::getAge));
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < listEmployees.length; i++) {
            System.out.println("a["+i+"]=" +listEmployees[i]);
        }


//        ArrayList<String> names = new ArrayList<>();
//        names.add("Vlad");
//        names.add("Igor");
//        names.add("Victor");
//        names.add("Slava");
//        Stream<Employee> stream = names.stream().map(Employee::new);
//        List<Employee> people = stream.collect(Collectors.toList());
//
//
//        Employee [] people = stream.toArray (Employee[]::new) ;
//
//
//        Timer timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
//        timer.start();
//        JOptionPane.showMessageDialog(null,"Quit program?");
//        System.exit(0);
//
//        Timer t = new Timer(1000,
//                event -> System.out.println("At the tone, time is " + new Date()));
//        Toolkit.getDefaultToolkit().beep();

    }

}
