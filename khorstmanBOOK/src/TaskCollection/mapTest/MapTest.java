package TaskCollection.mapTest;

import Task3.beans.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<String, Employee> map = new HashMap<>();
        map.put("1", new Employee("Ded Mazai",80,"USA"));
        map.put("2", new Employee("Shatunov",45,"Russia"));
        map.put("3", new Employee("Lavanda",33,"Brazil"));

        System.out.println("All elements as Map: " +map); //all elements at map

        System.out.println("Remove element: " +map.remove("2")); // remove Shatunov

        System.out.println("Finding element: " +map.get("3")); // find Lavanda

        for (Map.Entry<String, Employee> i: map.entrySet()) {
            String key = i.getKey();
            Employee employee = i.getValue();
            System.out.println("key = " + key + " value = " + employee);
        }

        map.forEach((key, employee) -> System.out.println("key = " + key + " value = " + employee)); //альтернатива цикла




    }

}
