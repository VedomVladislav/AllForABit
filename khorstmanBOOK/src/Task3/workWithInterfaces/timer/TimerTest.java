package Task3.workWithInterfaces.timer;

import javax.swing.*;
import javax.swing.Timer;

public class TimerTest {

    public static void main(String[] args) {

        ActionListener listener = (ActionListener) new TimePrinter();
        Timer t = new Timer(10000, (java.awt.event.ActionListener) listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }

}
