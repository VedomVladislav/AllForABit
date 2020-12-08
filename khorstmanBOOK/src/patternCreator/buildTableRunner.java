package patternCreator;

public class buildTableRunner {

    public static void main(String[] args) {

        Desc desk = new Desc(900,900,80);
        Legs[] legs = {
                new Legs(100, 100, 20),
                new Legs(100, 100, 20),
                new Legs(100, 100, 20),
                new Legs(100, 100, 20)
        };

        Table t = new Table(desk,legs);
        System.out.println(t.toString());

        t.out();

        Table table = new Table(900,900,80,20,4);
        table.out();

    }

}
