package patternCreator;

import java.util.Arrays;

public class Table {

    private Desc desk;
    private Legs[] legs;

    public Table(Desc desk, Legs[] legs) {
        this.desk = desk;
        this.legs = legs;
    }

    public Table(int width, int length, int height, int deskHeight, int countLegs) { //pattern Creator
        desk = new Desc(width,length,deskHeight);
        for (int i = 0; i < 4; i++) {
            legs[i] = new Legs(countLegs,countLegs, height - deskHeight);
        }
    }


    public void out() {
        System.out.println("This TABLE consist of: ");
        System.out.println("Desk: width = " +desk.getWidth()+ " length = " +desk.getLength()+ " height = " +desk.getHeight());
        System.out.println("Legs: ");
        for (int i = 0; i < 4; i++) {
            System.out.println("width = " +legs[i].getWidth()+ " length = " +legs[i].getLength()+ " height = " +legs[i].getHeight());
        }
    }
}
