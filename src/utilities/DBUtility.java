package utilities;

import models.Professor;
import models.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localhost:3306/edmuse";

    /**
     * This method will return a list of course codes from the DB
     */
    public static List<String> getCourseCodes()
    {
        return Arrays.asList("COMP 1002", "COMP 1030", "COMP 1035", "COMP 1045",
                "COMP 1045", "MATH 1003", "COMP 1006", "COMP 1008",
                "COMP 1098", "COMP 2003", "ENTR 1002", "COMP 1009",
                "COMP 1011", "COMP 1073", "COMP 2084", "COMP 3002",
                "COMP 2068");
    }

    public static ArrayList<Student> getStudentsFromDB() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        //create objects to access and read from the DB
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. create a Statement object that can be used to query the DB
            statement = conn.createStatement();

            //3.  execute the query
            resultSet = statement.executeQuery("SELECT * FROM students");

            //4.  loop over the result set and create student objects
            while (resultSet.next())
            {
                Student newStudent = new Student(resultSet.getString("firstName"),
                                                resultSet.getString("lastName"),
                                                resultSet.getString("address"),
                                                resultSet.getDate("birthday").toLocalDate(),
                                                resultSet.getInt("studentNum"));
                students.add(newStudent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            if (conn != null)
                conn.close();

            if (statement != null)
                statement.close();

            if (resultSet != null)
                resultSet.close();
        }
        return students;
    }

    public static ArrayList<String> getValidCourseCodesFromDB()  {
        ArrayList<String> courseCodes = new ArrayList<>();

        try(
                Connection conn = DriverManager.getConnection(connString, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT courseCode FROM approvedCourses");
                )
        {
            //4.  loop over the result set and create student objects
            while (resultSet.next())
                courseCodes.add(resultSet.getString(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return courseCodes;
    }

    public static ArrayList<Professor> getProfessorsFromDB()
    {
        ArrayList<Professor> professors = new ArrayList<>();
        professors.add(new Professor("Lois","Parker","674 Goyeau Ave Windsor ON N9A 1H9",LocalDate.of(1987,3,21),10100));
        professors.add(new Professor("Ginger","Harris","3514 Yonge Street Toronto ON M4W 1J7",LocalDate.of(1967,11,12),10101));
        professors.add(new Professor("Winchester","Solomon","3099 Balmy Beach Road Owen Sound ON N4K 2N7",LocalDate.of(1977,12,18),10102));
        professors.add(new Professor("John","Pressley","1101 Eglinton Avenue Toronto ON M4P 1A6",LocalDate.of(1973,11,29),10103));
        return professors;
    }

    /**
     * This method will insert a Student object  into  the database and return the student number
     */
    public static int insertStudentIntoDB(Student student) throws SQLException {
        int studentNum = -1;

        //create objects to access and read from the DB
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. create our sql statement and prepare it
            statement = conn.prepareStatement("INSERT INTO students (firstName, lastName, address, birthday) " +
                                                "VALUES(?,?,?,?);", new String[]{"studentNum"});

            //3.  bind the values to the datatypes
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getAddress());
            statement.setDate(4, Date.valueOf(student.getBirthday()));

            //4.  execute the insert
            statement.executeUpdate();

            //5.  get the student number returned
            resultSet = statement.getGeneratedKeys();

            //4.  loop over the result set and create student objects
            while (resultSet.next())
            {
                studentNum = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            if (conn != null)
                conn.close();

            if (statement != null)
                statement.close();

            if (resultSet != null)
                resultSet.close();
        }
        return studentNum;
    }

    public static ArrayList<String> getMajors()
    {
        ArrayList<String> majors = new ArrayList<>();
        majors.addAll(Arrays.asList("Acupuncture","Advanced Care Paramedic","Architectural Technology",
                "Art and Design Fundamentals","Artificial Intelligence", "Aviation Management","Computer Science"));
        return majors;
    }

}
