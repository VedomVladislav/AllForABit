package resource;

import javax.swing.*;
import java.awt.*;

public class ResourceTest {

    public static void main(String[] args) {

        EventQueue.invokeLater( () -> {
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("ResourceTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
