package Task4.innerAndAnonymousClasses;

import javax.swing.*;

public class AnonimousClassTest {

    public static void main(String[] args) {

        TalkingClockAnonymous clock = new TalkingClockAnonymous();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }

}
