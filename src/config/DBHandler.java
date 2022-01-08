package config;

import java.sql.*;
import java.util.Scanner;

public class DBHandler{

//  ------------------------------------Global Variables Starts Here ------------------------------------
    static Scanner scan = new Scanner(System.in);
    private static Connection connection = null;
    private static Statement stmt = null;

    private static int st_id;

    private static String conURL = "jdbc:mysql://localhost:3307/student_record?serverTimezone=UTC";
    private static String dbUsername = "root";
    private static String dbPassword = "";
//  ------------------------------------Global Variables ends Here ------------------------------------


//  ------------------------------------Setup Methods Starts Here ------------------------------------
    public static void connect(){
        try {
            connection = DriverManager.getConnection(conURL, dbUsername, dbPassword);
            System.out.println("Connection Established Successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }
//  ------------------------------------Setup Methods Ends Here ------------------------------------


//  ------------------------------------Students CRUD Operation Call starts here ------------------------------------
    public static void enrollStudent(String firstname, String lastname, int departmentId, int level, String tel){
        try {
             stmt = connection.createStatement();
            stmt.execute("insert into student(firstname, lastname, dept_id, level, tel) values ('"+firstname+"', '"+lastname+"', '"+departmentId+"', '"+level+"', '"+tel+"')");
            System.out.println("Record inserted successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void allStudents(){
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()){
                System.out.println("\n-----------------LIST OF DEPARTMENTS-----------------");
                System.out.println("Student ID: " + rs.getInt("stid"));
                System.out.println("First Name: " + rs.getString("firstname"));
                System.out.println("Last Name: " + rs.getString("lastname"));
//                System.out.println("Department: " + rs.getInt("dept_id"));
                System.out.println("Department: " + getDepartmentName(rs.getInt("dept_id")));
                System.out.println("Level: " + rs.getInt("level"));
                System.out.println("==========================================================\n");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

//  ------------------Update student record overloading starts here------------------
    public static void updateStudent(int studentId, String firstname, String lastname, int deptId, int level, String tel){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET firstname = '"+firstname+"', lastname = '"+lastname+"', dept_id = '"+deptId+"', level = '"+level+"', tel = '"+tel+"' WHERE stid = '"+studentId+"' ");
            System.out.println("Student " + getStudentName(studentId) + " record updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Update Student name
    public static void updateStudent(int studentId, String firstname, String lastname){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET firstname = '"+firstname+"', lastname = '"+lastname+"' WHERE stid = '"+studentId+"'");
            System.out.println("Student names updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Update Student firstname
    public static void updateStudent(String firstname, int studentId ){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET firstname = '"+firstname+"' WHERE stid = '"+studentId+"'");
            System.out.println("Student firstname updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Update Student lastname
    public static void updateStudent(int studentId, String lastname){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET lastname = '"+lastname+"' WHERE stid = '"+studentId+"'");
            System.out.println("Student lastname updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Update Student department
    public static void updateStudent(int studentId, int departmentId){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET dept_id = '"+departmentId+"' WHERE stid = '"+studentId+"'");
            System.out.println("Student " + getStudentName(studentId) + " department updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Update Student Telephone
    public static void updateStudent(int studentId){
        System.out.println("Enter Telephone:");
        String tel = scan.next();
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE student SET tel = '"+tel+"' WHERE stid = '"+studentId+"'");
            System.out.println("Student " + getStudentName(studentId) + " department updated successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//  ------------------ Update student record overloading ends here ------------------

    public static void deleteStudent(int studentId){
        try{
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM student WHERE stid = '"+studentId+"' ");
            System.out.println("Student Record Deleted Successfully!");
        }catch (Exception e){
            System.out.println("Error Message: " +e.getMessage());
        }
    }

    public static void getStudent(int id){
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where stid = '"+id+"'");
            while (rs.next()){
                System.out.println("------------------------- STUDENT RECORD -------------------------");
                System.out.println("Student ID: " + rs.getInt("stid"));
                System.out.println("First Name: " + rs.getString("firstname"));
                System.out.println("Last Name: " + rs.getString("lastname"));
//                System.out.println("Department: " + rs.getInt("dept_id"));
                System.out.println("Department: " + getDepartmentName(rs.getInt("dept_id")));
                System.out.println("Level: " + rs.getInt("level"));
                System.out.println("=====================================================================\n");
                return;
            }

            if (!rs.next()){
                System.out.println("No Record Found!");
//                return;
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static String getStudentName(int id){
        String fullname = "";

        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select firstname, lastname from student where stid = '" + id + "'");
            while (resultSet.next()){
                fullname = resultSet.getString("firstname") + " " + resultSet.getString("lastname");
                return fullname;
            }

            if (!resultSet.next()){
                System.out.println("No Record Found!");
                return "Null Student";
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
        return fullname;
    }
//  ------------------------------------Students CRUD Operation Call ends here ------------------------------------


//  ------------------------------------Course CRUD Operation here------------------------------------
    public static void newCourse(String courseName, int credit){
        try {
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO course(course_name, credit) VALUES('"+courseName+"', '"+credit+"')");
            System.out.println("Course added successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void allCourses(){
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select course_id, course_name, credit FROM course");
            System.out.println("\n*******************List of Courses*******************");
            System.out.println("============================================================");
            while (rs.next()){
                System.out.println("Course ID: " + rs.getInt("course_id"));
                System.out.println("Course Name: " + rs.getString("course_name"));
                System.out.println("Course Credit: " + rs.getInt("credit"));
                System.out.println("**************************************************\n");
//                return;
            }

//            if (!rs.next()){
//                System.out.println("No Record Found!");
//                return;
//            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void updateCourse(int courseId, String courseName, int credit){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE course SET course_name = '"+courseName+"', credit = '"+credit+"' WHERE course_id = '"+courseId+"'");
            System.out.println("Course Details Updated successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void updateCourse(int courseId, String courseName){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE course SET course_name = '"+courseName+"' WHERE course_id = '"+courseId+"'");
            System.out.println("Course Name Updated successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void updateCourse(int courseId, int credit){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE course SET credit = '"+credit+"' WHERE course_id = '"+courseId+"'");
            System.out.println("Course Credit Updated successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static String getCourseName(int courseId){
        String courseName = "";

        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select course_name from course where course_id = '" + courseId + "'");

            while (resultSet.next()){
                courseName = resultSet.getString("course_name");
                return courseName;
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
        return courseName;
    }

    public static void deleteCourse(int courseId){
        try {
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM course WHERE course_id = '" + courseId + "'");
            System.out.println("Course Deleted Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//  ------------------------------------Course CRUD Operation ends here ------------------------------------


//  ------------------------------------Marks CRUD Operation starts here ------------------------------------
    public static void addMarks(int studentId, int courseId, double cat, double exam){
        try {
            stmt = connection.createStatement();
            stmt.execute("insert into marks(stid, course_id, cat, exam) values('"+studentId+"', '"+courseId+"', '"+cat+"', '"+exam+"')");
            System.out.println("Marks added successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void getAllMarks(){
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT stid, course_id, cat, exam FROM marks");
            System.out.println("---------------------ALL MARKS---------------------");
            while (rs.next()){
                double cat = rs.getDouble("cat");
                double exam = rs.getDouble("exam");
                double total = cat + exam;

 /*
            Trying to display the student name who has this mark instead of just displaying id number manually
        ----------------------------------------------------------------------------------------------------------
                st_id = rs.getInt("stid");
                stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("select firstname, lastname FROM student WHERE stid = '" + st_id + "'");
                String fname = "";
                String lname = "";
                while (resultSet.next()){
                    fname = resultSet.getString("firstname");
                    lname = resultSet.getString("lastname");
                }
  */

//                Using function to find the name of the student who has the marks
                st_id = rs.getInt("stid");
                String fullname = getStudentName(st_id);

//                Using function to find the name of the student who has the marks
                int course_id = rs.getInt("course_id");
                String courseName = getCourseName(course_id);

//                Displaying Results
                System.out.println("Student ID: " + st_id);
                System.out.println("Name: " + fullname);
                System.out.println("Course ID: " + rs.getInt("course_id"));
                System.out.println("Course Name: " + courseName);
                System.out.println("CAT: " + cat);
                System.out.println("EXAM: " + exam);
                System.out.println("Total Marks: " + total);
                System.out.println("**************************************************\n");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void getStudentMark(int studentId){
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select stid, course_id, cat, exam from marks where stid = '" + studentId + "'");

            while (resultSet.next()){
                int student_id = resultSet.getInt("stid");
                int courseId = resultSet.getInt("course_id");
                double cat = resultSet.getDouble("cat");
                double exam = resultSet.getDouble("exam");
                double total = cat + exam;

                String courseName = getCourseName(courseId);

                System.out.println("Student ID: " + student_id);
                System.out.println("Course Name: " + courseName);
                System.out.println("Course ID: " + courseId);
                System.out.println("CAT: " + cat);
                System.out.println("EXam: " + exam);
                System.out.println("Total Marks: " + total);
                System.out.println("====================================================\n");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void getStudentMark(int studentId, int courseId){
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT stid, course_id, cat, exam from marks WHERE stid = '" + studentId + "' and course_id = '"+courseId+"' ");

            while (resultSet.next()){
                int student_id = resultSet.getInt("stid");
                int course_id = resultSet.getInt("course_id");
                double cat = resultSet.getDouble("cat");
                double exam = resultSet.getDouble("exam");
                double total = cat + exam;

                String courseName = getCourseName(course_id);

                System.out.println("Student ID: " + student_id);
                System.out.println("Course Name: " + courseName);
                System.out.println("Course ID: " + course_id);
                System.out.println("CAT: " + cat);
                System.out.println("EXam: " + exam);
                System.out.println("Total Marks: " + total);
                System.out.println("====================================================\n");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void updateMarks(int studentId, int courseId, double cat, double exam){
        try{
            stmt = connection.createStatement();

//            trying to check if the record requesting to be updated is available in the database before performing update operation.
            ResultSet resultSet = stmt.executeQuery("select * from marks where stid = '" + studentId + "' and course_id = '" + courseId + "'");

            int st_id = 0, c_id = 0;

            while (resultSet.next()){
                st_id = resultSet.getInt("stid");
                c_id = resultSet.getInt("course_id");
            }

            if (st_id != studentId || c_id != courseId){
                System.out.println("Record not exist! Check student id and course id again!");
            }else {
                stmt.execute("update marks set cat = '" + cat + "', exam = '" + exam + "' where stid = '" + studentId + "' and course_id='" + courseId + "'");
                System.out.println("Record updated successfully!");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }

    }

// For updating marks (either exam or cat marks)
    public static void updateMarks(int studentId, int courseId, double marks){
        try{
            stmt = connection.createStatement();

//            trying to check if the record requesting to be updated is available in the database before performing update operation.
            ResultSet resultSet = stmt.executeQuery("select * from marks where stid = '" + studentId + "' and course_id = '" + courseId + "'");

            int st_id = 0, c_id = 0;

            while (resultSet.next()){
                st_id = resultSet.getInt("stid");
                c_id = resultSet.getInt("course_id");
            }

            if (st_id != studentId || c_id != courseId){
                System.out.println("Record not exist! Check student id and course id again!");
            }else {
                System.out.println("-------------SELECT-------------\n" +
                        "1. CAT\n" +
                        "2. EXAM");
                int option = scan.nextInt();
                switch (option){
                    case 1:
                        stmt.execute("update marks set cat = '" + marks + "' where stid = '" + studentId + "' and course_id='" + courseId + "'");
                        System.out.println("Record updated successfully!");
                        break;
                    case 2:
                        stmt.execute("update marks set exam = '" + marks + "' where stid = '" + studentId + "' and course_id='" + courseId + "'");
                        System.out.println("Record updated successfully!");
                        break;
                    default:
                        System.out.println("Invalid Input!! \n Select 1 or 2!!");
                }
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }

    }

    public static void deleteMarks(int studentId, int courseId){
        System.out.println("Are you sure you want to delete " + getCourseName(courseId) + " marks of " + getStudentName(studentId) +" ? (yes/no)");
        String opt = scan.next();
        if (opt.equalsIgnoreCase("yes")){
            try{
                stmt = connection.createStatement();
                stmt.execute("DELETE FROM marks WHERE stid = '" + studentId + "' and course_id = '"+courseId+"' ");
                System.out.println("Marks Deleted!");
            }catch (Exception e){
                System.out.println("Error Message: " + e.getMessage());
            }
        }else {
            System.out.println("Record Not Deleted!");
        }
    }

    public static void getCourseMarks(int courseId){
        String courseName = getCourseName(courseId);
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select stid, course_id, cat, exam from marks where course_id = '" + courseId + "'");

            System.out.println("--------------------- LIST OF "+courseName+ " Marks ---------------------");
            while (resultSet.next()){
                int student_id = resultSet.getInt("stid");
//                int course_id = resultSet.getInt("course_id");
                double cat = resultSet.getDouble("cat");
                double exam = resultSet.getDouble("exam");
                double total = cat + exam;

                System.out.println("Student ID: " + student_id);
//                System.out.println("Course Name: " + courseName);
//                System.out.println("Course ID: " + course_id);
                System.out.println("CAT: " + cat);
                System.out.println("EXam: " + exam);
                System.out.println("Total Marks: " + total);
                System.out.println("========================================================================\n");
            }

        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }
//  ------------------------------------Marks CRUD Operation ends here ------------------------------------

//  ------------------------------------Department CRUD Operation Call starts here ------------------------------------
//    For adding new department
    public static void addDepartment(String name, String details){
        try {
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO department(name, details) VALUES('"+name+"', '"+details+"')");
            System.out.println("Department added successfully!");
        }catch (Exception ex){
            System.out.println("Error Message: " + ex.getMessage());
        }
    }

    public static void updateDepartment(int dept_id, String name, String details){
        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE department SET name = '" + name + "', details = '" + details + "' WHERE dept_id = '" + dept_id + "'");
            System.out.println("Department Updated Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void allDepartment(){
        try{
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dept_id, name, details FROM department");
            while (rs.next()){
                System.out.println("\n-----------------LIST OF DEPARTMENTS-----------------");
                System.out.println("Department ID: " + rs.getInt("dept_id"));
                System.out.println("Department Name: " + rs.getString("name"));
                System.out.println("Department Details: " + rs.getString("details"));
                System.out.println("**************************************************\n");
            }
        }catch (Exception e){
            System.out.println("Error Message: " + e.getMessage());
        }
    }

//    For Getting the department name to be used when deleting a department and other functions that may arise
    public static String getDepartmentName(int id){
        ResultSet rs = null;
        String deptName = "";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT name FROM department WHERE dept_id = '"+id+"'");
            while (rs.next()){
                deptName = rs.getString("name");
            }
        }catch (Exception e){
            System.out.println("Error Message: " + e.getMessage());
        }
        return deptName;
    }

    public static void deleteDepartment(int deptId){
        System.out.println("Are you sure you want to delete " + getDepartmentName(deptId) + " department? (yes/no)");
        String opt = scan.next();
        if (opt.equalsIgnoreCase("yes")){
            try{
                stmt = connection.createStatement();
                stmt.execute("DELETE FROM department WHERE dept_id = '" + deptId + "' ");
                System.out.println("Record Deleted!");
            }catch (Exception e){
                System.out.println("Error Message: " + e.getMessage());
            }
        }else {
            System.out.println("Record Not Deleted!");
        }
    }
//  ------------------------------------Department CRUD Operation Call ends here ------------------------------------

}
