package Task4.innerAndAnonymousClasses;

import javax.swing.*;

public class InnerClassTest {

    public static void main(String[] args) {

        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        TalkingClock jabberer = new TalkingClock(1000,true);
        TalkingClock.TimePrinter listener = jabberer. new TimePrinter () ;

    }

}
