package Annotation;

public abstract class Book implements Edition{

    String author = "God";
    String nameBook = "Illusion";
    int countStr = 700;
    String date = "00/00/0000";

    public void Description(int countStr, String author, String date) {
        System.out.print("Автор " + author + " выпустил книгу с названием " +nameBook+ " в "
                + date + " году, которая состоит из " +countStr+ " страниц");
    }
}
