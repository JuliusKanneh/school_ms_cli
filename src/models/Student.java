package models;

public class Student {
    private int studentId, level, departmentId;
    private String firstname, lastname, tel;

    public Student(int studentId, int level, String firstname, String lastname, int departmentId, String tel) {
        this.studentId = studentId;
        this.level = level;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentId = departmentId;
        this.tel = tel;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
