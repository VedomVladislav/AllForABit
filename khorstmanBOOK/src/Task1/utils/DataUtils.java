package Task1.utils;

import Task1.abstraction.Transport;
import Task1.exeptions.MyOwnExeption;
import Task1.implementation.Bus;
import Task1.implementation.Minibus;
import Task1.implementation.Trolleybus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataUtils {

    public static List<Transport> initCollection() throws MyOwnExeption {
        List<Transport> transportList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            transportList.add(new Bus("Bus " + i,Math.round(1000.0 + Math.random()*1000.0), 20 + Math.random()*20));
        }

        for (int i = 0; i < 3; i++) {
            transportList.add(new Trolleybus("Trolleybus " + i, Math.round(1000.0 + Math.random()*1000.0), 20 + Math.random()*20));
        }

        for (int i = 0; i < 3; i++) {
            transportList.add(new Minibus("MiniBus " + i, Math.round(1000.0 + Math.random()*1000.0), 20 + Math.random()*20));
        }

        for (Transport t : transportList) {
            int in = 0, out = 0;
            System.out.println("Transport capacity = " + t.getCapacity());
            System.out.println("Count people for " + t.getName() + " = " + t.getCountPeople());
            t.inPeople((int) (1 + Math.random() + 15));
            in = t.getCountPeople();
            System.out.println("In people for " + t.getName() + " = " + in);
            t.outPeople((int) (1 + Math.random() * 5));
            out = in - t.getCountPeople();
            System.out.println("Out people for " + t.getName() + " = " + out);
            System.out.println("All people for " + t.getName() + " = " + t.getCountPeople());
            if (t.getCountPeople() > t.getCapacity()) {
                throw new MyOwnExeption("Transport is full. Extra people ", t.getCountPeople() - t.getCapacity());
            }
        }

        return transportList;
    }

    public static double checkPrice(List<Transport> transports) {
        double sumPrice = 0;
        for (Transport t:transports) {
            sumPrice += t.getPrice();
        }
        return sumPrice;
    }


    public static List<Transport> diapazon(double minPrice, double maxPrice, double minCons, double maxCons, List<Transport> list) {
        List<Transport> tempList = new ArrayList<>();
         for (Transport t: list) {
            if(t.getPrice() >= minPrice && t.getPrice() <= maxPrice && t.getConsumption() >= minCons && t.getConsumption() <= maxCons)
                tempList.add(t);
        }
        return tempList;
    }

    @Deprecated /*Old method to compare. Lambda is the most convenient method.*/
    public static void oldSortList(List<Transport> list) {
        list.sort(new Comparator<Transport>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return (int) (o1.getConsumption() - o2.getConsumption());
            }
        });
    }

}
