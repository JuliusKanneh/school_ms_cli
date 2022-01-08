package models;

public class Department {
    private int departmentId;
    private String name;
    private String details;

    public Department(int departmentId, String name, String details) {
        this.departmentId = departmentId;
        this.name = name;
        this.details = details;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
