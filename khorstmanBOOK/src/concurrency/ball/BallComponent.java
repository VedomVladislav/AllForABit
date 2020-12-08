package concurrency.ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallComponent extends JPanel {

    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 550;

    private List<Ball> balls = new ArrayList<>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D gr2 = (Graphics2D) gr;
        for(Ball b: balls) {
            gr2.fill(b.getShare());
        }
    }

    public Dimension getPreferredSize() {return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}

}
