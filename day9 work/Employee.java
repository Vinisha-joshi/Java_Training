package day9;

public class Employee {
    private int id;
    private String Emp_Name;
    private Department department;

    public Employee( String emp_Name, Department department) {
        Emp_Name = emp_Name;
        this.department = department;
    }

    Employee() {

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_Name() {
        return Emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        Emp_Name = emp_Name;
    }

}
