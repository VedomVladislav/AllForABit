package Task3.reflection;

import Task3.beans.Employee;
import Task3.beans.Manager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        //Test OOP
        Manager manager1 = new Manager("Vasya", 10, "Minsk");
        manager1.setBonus(15);

        Employee[] employee = new Employee[3];

        employee[0] = manager1;
        employee[1] = new Employee("Petya", 15, "Brest");
        employee[2] = new Employee("Anna", 9, "Grodno");

        for (Employee e: employee) {
            System.out.println(e.toString());
        }

        Employee employee1 = new Employee("Gan",30,"Polotsk");
        Employee employee2 = new Employee("Gan",18,"Polotsk");

        System.out.println(employee1.equals(employee2));

        List<Employee> list = new ArrayList<>();
        list.add(manager1);
        list.add(new Employee("Petya", 15, "Brest"));
        list.add(new Employee("Anna", 9, "Grodno"));

        System.out.println(list);

        //Test Task3
        try {
            Employee harry = new Employee("Harry",80,"Moskow");
            // объект типа Class, представляющий класс Employee
            Class cl = harry.getClass();
            System.out.println("\nWork with Task3 API:");
            System.out.println("1)getclass(): " +cl);
            // поле name из класса Employee
            Field f = cl.getDeclaredField("name");
            System.out.println("2)getDeclaredField(): " +f);
            // значение в поле name объекта harry, т.е. объект типа String,
            // содержащий символьную строку "Harry"
            f.setAccessible(true); //разрешаем get(harry) к приватному полю
            Object v = f.get(harry);
            System.out.println("3)get(harry): " +v);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
