package Task2;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        int capacity;
        System.out.print("Enter size = ");
        Scanner scanner = new Scanner(System.in);
        capacity = scanner.nextInt();
        DynamicDoubleArray<Double> dynamicDoubleArray = new DynamicDoubleArray<>(capacity);

        capacity = dynamicDoubleArray.size();

        System.out.println("Capacity = " +capacity);

        dynamicDoubleArray.add(3);
        dynamicDoubleArray.add(7);
        dynamicDoubleArray.add(9);
        dynamicDoubleArray.add(1);
        dynamicDoubleArray.add(12);
        dynamicDoubleArray.add(90);
        dynamicDoubleArray.add(11);

        dynamicDoubleArray.printToString();

        System.out.println("Value on this position = " +dynamicDoubleArray.get(3));

        dynamicDoubleArray.deleteFromIndex(4);

        dynamicDoubleArray.printToString();

    }

}
