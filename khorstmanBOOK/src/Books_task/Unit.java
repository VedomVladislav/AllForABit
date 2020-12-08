package Books_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit {

    public static void show(List<Customer> list) {
        for (Customer o:
                list) {
            System.out.println(o.toString());
        }
    }

    public static void searchName(List<Customer> list) {
        Collections.sort(list, new Comparator<Customer>() {
            public int compare(Customer a, Customer b) {
                return a.last_name.compareToIgnoreCase(b.last_name);
            }
        });
        Unit.show(list);
        }

     public static void searchCardNumber(List<Customer> list, int start, int end) {
        List<Customer> new_list = new ArrayList<>();
        for (Customer temp : list) {
            if(temp.getCard_number() >= start && temp.getCard_number() <= end)
                new_list.add(temp);
        }
        Unit.show(new_list);
     }
    }
