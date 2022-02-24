package day9;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class AssociationExample {
    public static void main(String[] args) {
        addDepartmentAndEmployee();
//        Session session = Utility.getSession("AssociationExample.hbm.xml");
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        session.close();


    }


    private static void addDepartmentAndEmployee() {
        Session session = Utility.getSession("AssociationExample.hbm.xml");
        Transaction transaction = session.beginTransaction();
        Department department = new Department("CS");
        Department department2 = new Department("IT");
        Department department3 = new Department("EC");
        Employee employee = new Employee();
        employee.setEmp_Name("Vini");
        employee.setDepartment(department2);
        Employee employee1=new Employee();
        employee1.setEmp_Name("Akshita");
        employee1.setDepartment(department);
        session.persist(department);
        session.persist(department2);
        session.persist(department3);
        session.persist(employee);
        session.persist(employee1);
        transaction.commit();
    }
}
