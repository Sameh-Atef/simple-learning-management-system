import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Students.convertData("student-data","txt");
        Courses.convertData("Coursedata","xml");


    }

}