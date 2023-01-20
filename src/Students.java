import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Students extends Data{
// method to display student-data.csv
    public static void displayData() throws IOException {
        List<String>Student=new ArrayList<>();

        // creates scanner of that file path
        //Scanner scan = new Scanner(new File("src/data/student-data.csv"));
        // read till there aren't elements
        final File input = new File("src/data/student-data.csv");
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(input));
        String line = null;
        displayHeader();

        while ((line = reader.readLine()) != null) {

            // use comma as separator
            String[] fields = line.split(",");
            formatData(fields);

            System.out.println();
        }

    }
    public static void convertData(String fileName,String type){
        final File input = new File("src/data/"+fileName+"."+type);
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = null;
            String[] tokens = new String[0];
            while((line = reader.readLine()) != null){
                tokens = line.split("\\$");
            }
            for (String s: tokens){
                output.add(s.replace("#",","));
            }
            //test output list by get method
           //System.out.println(output.get(100));
            reader.close();
            writeData(output,"student-data.csv");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void readData (List<String>input){

    }






    // function used to format our csv data accord to requirements
    private static void formatData(String [] fields  ) {

        for(String field : fields) {
//search for pattern that can match only digit
            Pattern pattern1 = Pattern.compile("(\\S|\\d)");
            Matcher matcher1 = pattern1.matcher(field);
            if (matcher1.find()) {
                System.out.printf("%-37s",field);
            }
            else{
//expect to get non-digit data with this format

                System.out.printf("%-50s",field);
            }

    }



    }
        private static void displayHeader(){
            System.out.println("---------------------------------------------------------");
            System.out.println("Current Student List");
            System.out.println("---------------------------------------------------------");
        }


     public static void displayData(String id) throws IOException {
        List<String>Student=new ArrayList<>();

        // creates scanner of that file path
        //Scanner scan = new Scanner(new File("src/data/student-data.csv"));
        // read till there aren't elements
        final File input = new File("src/data/student-data.csv");
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(input));
        String line = null;

        while ((line = reader.readLine()) != null ) {

            // use comma as separator
            String[] fields = line.split(",");
            if(fields.equals("jj")){
            formatData(fields);
            break;
            }

            System.out.println();
        }

    }

}
