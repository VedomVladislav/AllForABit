package Books_task;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Petrov", "Serdicha", 111, "30201030");
        Customer customer2 = new Customer(2, "Ivanov", "Google", 222, "66545722");
        Customer customer3 = new Customer(3, "Sidorov", "Itra", 333, "12345211");
        Customer customer4 = new Customer(4, "Lisichik", "Pomoika", 10000, "18674424");
        Customer customer5 = new Customer(5, "Popov", "Gaz", 999, "13456721");

        List<Customer> list = new ArrayList();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        list.add(customer4);
        list.add(customer5);

        Unit.show(list);
        Unit.searchName(list);


//        Unit.searchName(list);

        Unit.searchCardNumber(list, 200, 1000);
    }
}

