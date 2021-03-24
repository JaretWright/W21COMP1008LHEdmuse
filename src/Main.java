import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {


       //ArrayList example of handling grades (no association with the courses)
       ArrayList<Integer> awesomeGrades = new ArrayList<>();
       awesomeGrades.add(99);
       awesomeGrades.add(100);
       awesomeGrades.add(97);
       for (Integer grade : awesomeGrades)
           System.out.println(grade);

       //doing the same thing with a TreeMap (associating with the courses)
       TreeMap<String, Integer> grades = new TreeMap<>();
       grades.put("COMP 1008",100);
       grades.put("COMP 1030", 97);
       grades.put("COMP 1011", 98);

       //use the keys to get the values
       for (String courseCode : grades.keySet())
           System.out.printf("Course: %s   Grade Earned: %d%n",courseCode, grades.get(courseCode));

    }
}
