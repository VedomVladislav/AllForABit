package Task1.runner;

import Task1.abstraction.Transport;
import Task1.exeptions.MyOwnExeption;
import Task1.implementation.Bus;
import Task1.utils.DataUtils;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws MyOwnExeption {
        System.out.println("------ПАРК ОБЩЕСТВЕННОГО ТРАНСПОРТА-------");
        List<Transport> list = DataUtils.initCollection();
            for (Transport t : list) {
                System.out.println(t.toString());
            }
            System.out.println("------ПАРК ОБЩЕСТВЕННОГО ТРАНСПОРТА-------");


            System.out.println("Общая стоимость парка = " + DataUtils.checkPrice(list));

            System.out.println("------Сортируем-------");
            list.sort((o1, o2) -> (int) (o1.getConsumption() - o2.getConsumption()));

            System.out.println("------Результат сортировки-------");
            for (Transport t : list) {
                System.out.println(t.toString());
            }
            System.out.println("------Результат сортировки-------");

            System.out.println("------Вхождение в диапазон-------");
            System.out.println(DataUtils.diapazon(1500, 2000, 20, 40, list));
            System.out.println("------Вхождение в диапазон-------");

            System.out.println("------Тест FINAL метода-------");
            Transport testT = new Bus("BusForFinal", 500, 10);
            testT.printMessage();
            ((Bus) testT).printMessageBUS();
            System.out.println("------Тест FINAL метода-------");


            Bus bus = new Bus("Bus", 100, 20);
            bus.setCountPeople(3);
            bus.setCountPeople(bus.getCountPeople() + 4);
            System.out.println(bus.getCountPeople());
        }
    }
