package Task4.innerAndAnonymousClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {

    private  int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {

//        class TimePrinter implements ActionListener { //локальный класс без модификатора доступа!!
//
//            private TalkingClock outer; //link to TalkingClock
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("At the tone, the time is " + new Date());
//                if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep(); // beep = true, if you want to hear beep
//            }
//
//        }

        ActionListener actionListener = new TimePrinter();
        Timer t = new Timer(interval,actionListener);
        t.start();
    }

    public void start(int interval, final boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };

        Timer t = new Timer(interval, listener);
        t.start();
    }

    //внутренний класс
    public class TimePrinter implements ActionListener {

        private TalkingClock outer; //link to TalkingClock

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep(); // beep = true, if you want to hear beep
        }

    }

}
