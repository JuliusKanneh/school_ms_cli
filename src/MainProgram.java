import config.DBHandler;
import models.Course;
import models.Department;
import models.Mark;
import models.Student;

import java.util.Scanner;

public class MainProgram extends DBHandler {

//  ------------------------------------Global Variables Starts Here ------------------------------------
    Scanner in = new Scanner(System.in);
    private static Student student;
    private Mark mark;
    private Course course;
    private Department department;
//  ------------------------------------Global Variables ends Here ------------------------------------


//  ------------------------------------Setup Methods Starts Here ------------------------------------
    public void displayStudent(){
        System.out.println(student.getStudentId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        System.out.println(student.getDepartmentId());
        System.out.println(student.getLevel());
    }

    public void backToMenu(){
        System.out.println("Back to menu? (yes/no)");
        String response = in.next();
        if (response.equalsIgnoreCase("yes")){
            menu();
        }else {
            System.out.println("Goodbye!");
            return;
        }
    }

//    public void menu1(){
//        System.out.println("---------------------------MENU---------------------------\n" +
//                "1. Students Operations\n" +
//                "2. Course Operations\n" +
//                "3. Marks Operations\n" +
//                "4. Departments\n");
//
//    }

    public void menu(){
        System.out.println("-----------MENU-------------\n" +
                "1. Enroll New Student\n" +
                "2. View All Students\n" +
                "3. Edit Student Record\n" +
                "4. Delete Student Record\n" +
                "5. Find Student\n" +
                "6. Add New Course\n" +
                "7. View all Courses\n" +
                "8. Edit Course Record\n" +
                "9. Delete Course Record\n" +
                "10. Add Student Mark\n" +
                "11. View all Marks\n" +
                "12. Update Mark\n" +
                "13. Delete Mark\n" +
                "14. Generate a Student Mark\n" +
                "15. Generate Marks of a course\n" +
                "16. Add New Department\n" +
                "17. Edit Department Information\n" +
                "18. Delete a Department\n" +
                "19. View all department\n");

        int option = in.nextInt();

        switch (option){
            case 1:
                enrollStudent();
                backToMenu();
                break;
            case 2:
                allStudents();
                backToMenu();
                break;
            case 3:
                updateStudent();
                backToMenu();
                break;
            case 4:
                deleteStudent();
                backToMenu();
                break;
            case 5:
                findStudent();
                backToMenu();
                break;
            case 6:
                newCourse();
                backToMenu();
                break;
            case 7:
                allCourses();
                backToMenu();
                break;
            case 8:
                updateCourse();
                backToMenu();
                break;
            case 9:
                deleteCourse();
                backToMenu();
                break;
            case 10:
                addMarks();
                backToMenu();
                break;
            case 11:
                getAllMarks();
                backToMenu();
                break;
            case 12:
                updateMarks();
                backToMenu();
                break;
            case 13:
                deleteMarks();
                backToMenu();
                break;
            case 14:
                callGetStudentMarks();
                backToMenu();
                break;
            case 15:
                getCourseMarks();
                backToMenu();
                break;
            case 16:
                addDepartment();
                backToMenu();
                break;
            case 17:
                updateDepartment();
                backToMenu();
                break;
            case 18:
                deleteDepartment();
                backToMenu();
                break;
            case 19:
                allDepartment();
                backToMenu();
                break;
            default:
                System.out.println("Wrong Choice!!");
                backToMenu();
        }
    }
//  ------------------------------------Setup Methods Ends Here ------------------------------------


//  ------------------------------------Students CRUD Operation Call starts here ------------------------------------
    public void enrollStudent(){
        student = new Student();

        System.out.println("Enter First Name: ");
        student.setFirstname(in.next());
        System.out.println("Enter Last Name: ");
        student.setLastname(in.next());
        System.out.println("Enter Level: ");
        student.setLevel(in.nextInt());
        System.out.println("Enter Department ID:");
        student.setDepartmentId(in.nextInt());
        System.out.println("Enter Telephone:");
        student.setTel(in.next());

        enrollStudent(student.getFirstname(),student.getLastname(), student.getDepartmentId(), student.getLevel(), student.getTel());
    }

    public void editStudentDetails(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());
        System.out.println("Enter First Name: ");
        student.setFirstname(in.next());
        System.out.println("Enter Last Name: ");
        student.setLastname(in.next());
        System.out.println("Enter Level: ");
        student.setLevel(in.nextInt());
        System.out.println("Enter Department ID:");
        student.setDepartmentId(in.nextInt());
        System.out.println("Enter Telephone:");
        student.setTel(in.next());

        updateStudent(student.getStudentId(),student.getFirstname(),student.getLastname(), student.getDepartmentId(), student.getLevel(), student.getTel());
    }

    public void editStudentNames(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());
        System.out.println("Enter First Name: ");
        student.setFirstname(in.next());
        System.out.println("Enter Last Name: ");
        student.setLastname(in.next());

        updateStudent(student.getStudentId(),student.getFirstname(),student.getLastname());
    }

    public void editStudentFirstname(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());
        System.out.println("Enter First Name: ");
        student.setFirstname(in.next());

        updateStudent(student.getFirstname(), student.getStudentId());
    }

    public void editStudentLastname(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());
        System.out.println("Enter Last Name: ");
        student.setLastname(in.next());

        updateStudent(student.getStudentId(),student.getLastname());
    }

    public void editStudentDepartment(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());
        System.out.println("Enter Department ID: ");
        student.setDepartmentId(in.nextInt());

        updateStudent(student.getStudentId(), student.getDepartmentId());
    }

    public void editStudentTel(){
        student = new Student();

        System.out.println("Enter ID: ");
        student.setStudentId(in.nextInt());

        updateStudent(student.getStudentId());
    }

    public void updateStudent(){
        System.out.println("-------------------- MENU --------------------\n" +
                "1. Edit All Details\n" +
                "2. Edit Names\n" +
                "3. Edit Firstname\n" +
                "4. Edit Lastname\n" +
                "5. Edit Department\n" +
                "6. Edit Telephone\n");
        int option = in.nextInt();
        switch (option){
            case 1:
                editStudentDetails();
                break;
            case 2:
                editStudentNames();
                break;
            case 3:
                System.out.println("Edit Firstname");
                editStudentFirstname();
                break;
            case 4:
                System.out.println("Edit Lastname");
                editStudentLastname();
                break;
            case 5:
                System.out.println("Edit Department");
                editStudentDepartment();
                break;
            case 6:
                editStudentTel();
                break;
            default:
                System.out.println("Choice out of range!");
        }

    }

    public void deleteStudent(){
        System.out.println("Student ID: ");
        int studentId = in.nextInt();
        deleteStudent(studentId);
    }

    public void findStudent(){
        System.out.println("Enter Student ID: ");
        int id = in.nextInt();
        getStudent(id);
    }
//  ------------------------------------Students CRUD Operation Call ends here ------------------------------------


//  ------------------------------------Course CRUD Operation Call starts here ------------------------------------
    public void newCourse(){
        course = new Course();

        System.out.println("Enter Course Name: ");
        course.setCourseName(in.next());
        System.out.println("Enter Course Credit: ");
        course.setCredit(in.nextInt());

        newCourse(course.getCourseName(), course.getCredit());
    }

    public void editCourseDetails(){
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        System.out.println("Enter Course Name: ");
        String courseName = in.next();
        System.out.println("Enter Number of Credits: ");
        int courseCredit = in.nextInt();

        updateCourse(courseId, courseName, courseCredit);
    }

    public void editCourseName(){
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        System.out.println("Enter Course Name: ");
        String courseName = in.next();

        updateCourse(courseId, courseName);
    }

    public void editCourseCredit(){
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        System.out.println("Enter Course Credit: ");
        int courseCredit = in.nextInt();

        updateCourse(courseId, courseCredit);
    }

    public void updateCourse(){
        System.out.println("-------------------- MENU --------------------\n" +
                "1. Edit All Details\n" +
                "2. Edit Course Name\n" +
                "3. Edit Course Credit\n");
        int option = in.nextInt();
        switch (option){
            case 1:
                editCourseDetails();
                break;
            case 2:
                editCourseName();
                break;
            case 3:
                editCourseCredit();
                break;
            default:
                System.out.println("Choice out of range!");
        }

    }

    public void deleteCourse(){
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        deleteCourse(courseId);
    }
//  ------------------------------------Course CRUD Operation Call ends here ------------------------------------


//  ------------------------------------Marks CRUD Operation Call starts here ------------------------------------
    public void addMarks(){
        mark = new Mark();

        System.out.println("Enter Student ID:");
        mark.setStudentId(in.nextInt());
        System.out.println("Enter Course ID:");
        mark.setCourseId(in.nextInt());
        System.out.println("Enter CAT Marks:");
        mark.setCat(in.nextDouble());
        System.out.println("Enter Exam Marks:");
        mark.setExam(in.nextDouble());

        addMarks(mark.getStudentId(), mark.getCourseId(), mark.getCat(), mark.getExam());
    }

    public void callGetStudentMarks(){
        System.out.println("Enter Student ID: ");
        int std_id = in.nextInt();

        System.out.println("---------- MENU ----------");
        System.out.println("1. All Marks\n" +
                "2. For a course\n");
        int opt = in.nextInt();
        switch (opt){
            case 1:
                getStudentMark(std_id);
                break;
            case 2:
                System.out.println("Enter Course ID:");
                int course_id = in.nextInt();
                getStudentMark(std_id, course_id);
                break;
            default:
                System.out.println("Wrong Choice");
        }

    }

    public void updateMarks(){
        int studentId, courseId;
        double cat, exam;

        System.out.println("Enter Student Id: ");
        studentId = in.nextInt();
        System.out.println("Enter Course Id: ");
        courseId = in.nextInt();

        System.out.println("*****************Which Marks would you like to update?*****************\n" +
                "1. SINGLE\n" +
                "2. BOTH");
        int opt = in.nextInt();
        switch (opt){
            case 1:
                System.out.println("Enter Marks, cat or exam: ");
                double marks = in.nextInt();
                updateMarks(studentId, courseId, marks);
                break;
            case 2:
                System.out.println("Enter CAT marks: ");
                cat = in.nextDouble();
                System.out.println("Enter Exam marks: ");
                exam = in.nextDouble();
                updateMarks(studentId, courseId, cat, exam);
                break;
            default:
                System.out.println("Choice out of range!!");
        }
    }

    public void deleteMarks(){
        System.out.println("Enter Student ID: ");
        int studentId = in.nextInt();
        System.out.println("Enter Course ID: ");
        int courseId = in.nextInt();
        deleteMarks(studentId, courseId);
    }

    public void getCourseMarks(){
        System.out.println("Enter Course ID: ");
        int course_id = in.nextInt();
        getCourseMarks(course_id);
    }
//  ------------------------------------Marks CRUD Operation Call ends here ------------------------------------


//  ------------------------------------Department CRUD Operation Call starts here ------------------------------------
    public void addDepartment(){
        department = new Department();

        System.out.println("Enter Department Name:");
        department.setName(in.next());
        System.out.println("Enter Details:");
        department.setDetails(in.next());

        addDepartment(department.getName(), department.getDetails());
    }

    public void updateDepartment(){
        System.out.println("Enter Department ID");
        int deptId = in.nextInt();
        System.out.println("Enter Department Name");
        String deptName = in.next();
        System.out.println("Enter Department Details");
        String deptDetails = in.next();

        updateDepartment(deptId,deptName, deptDetails);
    }

    public void deleteDepartment(){
        System.out.println("Enter Department ID: ");
        int deptId = in.nextInt();
        deleteDepartment(deptId);
    }
//  ------------------------------------Department CRUD Operation Call ends here ------------------------------------

//    Main Method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MainProgram obj = new MainProgram();

        connect();
        obj.menu();
    }

}
