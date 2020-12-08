package TaskCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        System.out.println(list);
        for (int i = 0; list.size() >= 2; i++) {
            int x = list.size();
            int j = 0;
            if(i != 0 && i % 2 == 0 && x % 2 !=0) {
                j = 0;
            }
            else if(i % 2 == 0 ) {
                j = 1;
            } else {
                x--;
            }
            for (; j < x / 2 + 1; j++) {
                list.remove(j);
            }
            System.out.println(list);
        }


    }
}
