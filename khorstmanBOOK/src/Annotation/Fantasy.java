package Annotation;

public class Fantasy extends Book{
    String author;
    int countStr;
    String date;

    @Override
    public void release() {
        System.out.print("ФАНТАСТИКА");
    }

    @Override
    public void Description(int countStr, String author, String date) {
        super.Description(countStr, author, date);
    }
}
