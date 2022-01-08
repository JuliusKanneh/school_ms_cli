package models;

public class Mark {
    private int studentId, courseId;
    private double cat, exam;

    public Mark(int studentId, int courseId, double cat, double exam) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.cat = cat;
        this.exam = exam;
    }

    public Mark() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getCat() {
        return cat;
    }

    public void setCat(double cat) {
        this.cat = cat;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }
}
