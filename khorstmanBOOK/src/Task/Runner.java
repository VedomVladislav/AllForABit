package Task;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        System.out.println("------------------------");
        Figure sq = new Square(5, 2);
        System.out.println(sq.square());

        Figure tr = new Triangle(5, 2);
        System.out.println(tr.square());

        Figure cir = new Circle(2);
        System.out.println(cir.square());
        System.out.println("------------------------");

        TestReflection testReflection = new TestReflection();
        testReflection.printClassInfo(tr);
        testReflection.printClassInfo(new Square(100, 200));
        System.out.println("------------------------");

        try {
            Class carClass = Class.forName("Task.Circle");
            System.out.println(carClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------");
        ArrayList arrayList = new ArrayList();

        arrayList.add(sq);
        arrayList.add(tr);
        arrayList.add(cir);

        testReflection.classesInfo(arrayList);

    }
}
