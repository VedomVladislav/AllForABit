package Task4.innerAndAnonymousClasses;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TalkingClockAnonymous {

    //лямбда лучше
//    public void start(int interval, boolean beep) {
//        ActionListener listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("At the tone, the time is " + new Date());
//                if(beep) Toolkit.getDefaultToolkit().beep();
//            }
//        };
//        Timer t = new Timer(interval, (java.awt.event.ActionListener) listener);
//        t.start();
//
//    }

    //через лямба-выражения
    public void start(int interval, boolean beep) {
        Timer t = new Timer(interval, e ->
        {
            System.out.println("At the tone, the time is " + new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        });
        t.start();
    }

}
