package models;

public class Course {
    private int courseId, credit;
    private String courseName;

    public Course(int courseId, int credit, String courseName) {
        this.courseId = courseId;
        this.credit = credit;
        this.courseName = courseName;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
