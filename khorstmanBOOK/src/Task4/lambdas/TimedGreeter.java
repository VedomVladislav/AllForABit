package Task4.lambdas;

import javax.swing.*;

public class TimedGreeter extends Greeter {

    public void greet() {

        Timer t = new Timer(1000, super::greet);
        t.start();

    }

}
