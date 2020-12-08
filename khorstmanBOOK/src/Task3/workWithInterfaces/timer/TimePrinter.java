package Task3.workWithInterfaces.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class TimePrinter implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
