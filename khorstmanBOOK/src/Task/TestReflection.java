package Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReflection {

    public void printClassInfo(Object object) {

        Class clazz = object.getClass();
        System.out.println("Имя класса: " +clazz);
        System.out.println("Имена переменных: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Имя суперкласса: " + clazz.getSuperclass());
        System.out.println("Имена методов: " + Arrays.toString(clazz.getMethods()));
    }

    public void classesInfo(ArrayList list) {
        for (Object o: list) {
            System.out.println("Имя класса: " +o.getClass());
        }
    }


}

