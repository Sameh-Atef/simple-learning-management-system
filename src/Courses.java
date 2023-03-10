import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Courses extends Data {
    // convert Data from coursedata.xml to coursedata. csv
    public static void convertData(String fileName,String type) throws IOException {
        final File input = new File("src/data/"+fileName+"."+type);
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = null;
            String[] tokens = new String[0];
            String words = null;
            output.add("id" + "," + "CourseName" + "," + "Instructor" + "," + "CourseDuration" + "," + "CourseTime" + "," + "Location");


            while ((line = reader.readLine()) != null) {
                if(line.contains("id")) {
                    String id = extractValue(line,"<id>","</id>");
                    String CourseName = extractValue(reader.readLine(),"<CourseName>","</CourseName>");
                    String Instructor = extractValue(reader.readLine(),"<Instructor>","</Instructor>").replaceAll(",",". ");
                    String CourseDuration = extractValue(reader.readLine(),"<CourseDuration>","</CourseDuration>");
                    String CourseTime = extractValue(reader.readLine(),"<CourseTime>","</CourseTime>");
                    String Location = extractValue(reader.readLine(),"<Location>","</Location>");
                    output.add(id + "," + CourseName + "," + Instructor + "," + CourseDuration + "," + CourseTime + "," + Location);
                }


            }
            reader.close();
            writeData(output,"coursedata.csv");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
            try {
                reader.close();
                //writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String extractValue(String line,String start, String end ) {
        //pattern to parser xml created by trying and error
            Pattern pattern = Pattern.compile(start+"(\\S+|\\S+ \\S+|\\S+?, \\S+ \\S.|\\S+ \\S+.|\\S+ \\S+ . |\\S+ \\S+ \\S+.|\\S+ \\S+ &amp; \\S+.)"+end);
            Matcher matcher = pattern.matcher(line);
            String str = null;
            if (matcher.find()) {
                //str = null;
                str = matcher.group(1);
                //System.out.println(str);
            }
            //return str;
            return str;
            //return "Not-found";
        }
    public static void displayData(String id) throws IOException {
        List<String>Course=new ArrayList<>();

        // creates scanner of that file path
        //Scanner scan = new Scanner(new File("src/data/student-data.csv"));
        // read till there aren't elements
        final File input = new File("src/data/coursedata.csv");
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(input));
        String line = null;
        //displayHeader1();
        while ((line = reader.readLine()) != null ) {

            // use comma as separator
            String[] fields = line.split(",");

            formatData(fields, id);
            //System.out.println();
        }
    }
    private static void formatData(String [] fields, String id ) {
        //System.out.printf("%-25s",fields[0]);

        for(String field : fields) {
            int i = 1;
            if (field.equals((id))) {
                System.out.printf("%-10s%-30s%-30s%-30s%-20s",field,fields[i],fields[i+1],fields[i+2],fields[i+3]);
                System.out.println();

            } else {
                break;
            }

        }





    }
    // Header for display as a title of course details
    public static void displayHeader1(){
        System.out.printf("%-10s%-30s%-30s%-30s%-20s","id","CourseName","Instructor","CourseDuration","CourseTime");
        System.out.println();
    }

}

