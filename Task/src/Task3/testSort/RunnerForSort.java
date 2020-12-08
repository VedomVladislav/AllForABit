package Task3.testSort;

import Task3.beans.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RunnerForSort {

    public static void main(String[] args) {

        Employee[] masEmployee = new Employee[3];
        masEmployee[0] = new Employee("Vlad", 24,"Serdicha 76-37");
        masEmployee[1] = new Employee("Alex", 23,"Pobeditelei 13");
        masEmployee[2] = new Employee("Sergei", 20,"Senica 80-9");

        Arrays.sort(masEmployee);

        for (Employee e: masEmployee) {
            System.out.println("name = " + e.getName() + ", " +
                    "age = " + e.getAge());
        }

    }

}
