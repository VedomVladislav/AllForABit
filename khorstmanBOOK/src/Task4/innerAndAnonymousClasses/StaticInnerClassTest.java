package Task4.innerAndAnonymousClasses;

import java.time.LocalDate;

public class StaticInnerClassTest {

    public static void main(String[] args) {

        String[] d = new String[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = String.valueOf(100*Math.random());
        }

        ArrayAlg.Pair<String> pString = ArrayAlg.minmax(d);
        System.out.println("Minimus at d[] = " + pString.getFirst());
        System.out.println("Maximum at d[] = " + pString.getSecond());


        double dob = ArrayAlg.getMiddle(2.33, 5.421, 0.22);
        System.out.println("Double middle = " +dob);

        int in = ArrayAlg.getMiddle(1,4,5,2,66,5,1,2);
        System.out.println("Integer middle = " +in);

        String str = ArrayAlg.getMiddle("Hello", "World", "!!!");
        System.out.println("String middle = " +str);

        LocalDate[] localDates =
                {
                        LocalDate.of(1906,12,9),
                        LocalDate.of(1955,3,17),
                        LocalDate.of(1910,7,10),
                        LocalDate.of(1876,1,19)
                };
        ArrayAlg.Pair<LocalDate> test = ArrayAlg.minmax(localDates);
        System.out.println("minDate = " +test.getFirst());
        System.out.println("maxDate = " +test.getSecond());


    }

}
