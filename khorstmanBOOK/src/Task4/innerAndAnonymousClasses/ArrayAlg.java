package Task4.innerAndAnonymousClasses;

import java.io.Serializable;

public class ArrayAlg {

    public static class Pair<T> { //статический внутренний (вложенный) класс

        private T first;
        private T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

    }

    public static <T extends Comparable> Pair<T> minmax(T[] values) {

        if(values == null || values.length == 0) return null;

        T min = values[0];
        T max = values[0];

        for (int i = 1; i < values.length; i++) {
            if(min.compareTo(values[i]) > 0) min = values[i];
            if(max.compareTo(values[i]) < 0) max = values[i];
        }

        return new Pair<>(min, max);
    }


    public static <T> T getMiddle(T...a) {
        return a[a.length/2];
    }


}
