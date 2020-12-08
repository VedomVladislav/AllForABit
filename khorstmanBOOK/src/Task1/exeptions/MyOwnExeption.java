package Task1.exeptions;

public class MyOwnExeption extends Exception {

    private int number;

    public MyOwnExeption() {
    }

    public int getNumber() {
        return number;
    }

    public MyOwnExeption(String message, int num) {
        super(message);
        number = num;
        System.out.println("Transport is full. Extra people " + number);
    }

    public void printMessageExeption() {
        System.out.println("Transport is full. Extra people " + number);
    }

}
