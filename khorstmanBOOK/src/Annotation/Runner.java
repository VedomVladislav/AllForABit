package Annotation;

public class Runner {

    public static void main(String[] args) {
	    Book fantasy = new Fantasy();
        fantasy.Description(100,"Ivanov","01/12/2009");
        System.out.println("\n");
        Book detective = new Detective();
        detective.Description(500,"Lisichik","01/12/2015");
    }
}
