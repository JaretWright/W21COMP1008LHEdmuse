package models;

import utilities.DBUtility;

import java.time.LocalDate;
import java.util.TreeMap;

public class Student extends Person{
    private int studentNum;
    private TreeMap<String, Integer> grades;

    public Student(String firstName, String lastName, String address, LocalDate birthday, int studentNum) {
        super(firstName, lastName, address, birthday);
        setStudentNum(studentNum);
        grades = new TreeMap<>();
    }

    public Student(String firstName, String lastName, String address, LocalDate birthday) {
        super(firstName, lastName, address, birthday);
        grades = new TreeMap<>();
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * This method will validate both the course code and the grade, then add the combination
     * to the grades colleciton
     */
    public void addGrade(String courseCode, int grade)
    {
        //validate the course code
        if (!DBUtility.getCourseCodes().contains(courseCode))
            throw new IllegalArgumentException(courseCode + " is not a defined course in the database");

        if (grade>=0 && grade<=100)
            grades.put(courseCode, grade);
        else
            throw new IllegalArgumentException("grade must be in the range 0-100");
    }

    /**
     * This method will return the grade for a specific course
     * @return if the course is in the grades, the grade earned will be returned.  -1 will be returned if the course does not exist
     */
    public int getGradeForCourse(String courseCode)
    {
        //if the course does not exist, return -1
        if (grades.get(courseCode)== null)
            return -1;

        return grades.get(courseCode);
    }

    /**
     * This method will return the number of courses passed
     */
    public int getNumOfCoursesPassed()
    {
        int count = 0;

        for(Integer grade : grades.values())
        {
            if (grade>=50)
                count++;
        }

        return count;
    }

    /**
     * Return the average grade.  -1 if the student does not have any grades defined yet
     */
    public double getAverageGrade()
    {
        if (grades.size()==0)
            return -1;

        double total=0;
        for (Integer grade: grades.values())
            total += grade;

        return total/grades.size();
    }

    public TreeMap<String, Integer> getGrades() {
        return grades;
    }
}
