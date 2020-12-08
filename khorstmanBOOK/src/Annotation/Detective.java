package Annotation;

public class Detective extends Book {
    String author;
    int countStr;
    String date;

    @Override
    public void release() {
        System.out.print("ДЕТЕКТИВ");
    }

    @Override
    public void Description(int countStr, String author, String date) {
        super.Description(countStr, author, date);
    }
}
