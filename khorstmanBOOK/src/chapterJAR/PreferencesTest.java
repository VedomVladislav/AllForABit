package chapterJAR;

import javax.swing.*;
import java.awt.*;

public class PreferencesTest {

    public static void main(String[] args) {

        EventQueue.invokeLater( () -> {
            PreferencesFrame preferencesFrame = new PreferencesFrame();
            preferencesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            preferencesFrame.setVisible(true);
        });

    }

}
