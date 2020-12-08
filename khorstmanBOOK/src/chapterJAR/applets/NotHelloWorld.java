package chapterJAR.applets;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld extends JApplet {

    public void init() {
        EventQueue.invokeLater( () -> {
            JLabel label = new JLabel("Not Hello World!!", SwingConstants.CENTER);
            add(label);
        });
    }
}
