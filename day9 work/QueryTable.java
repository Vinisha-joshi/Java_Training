//package day8;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.List;
///*
//SessionFactory has a field
//	private final transient Map<String,Object> properties;
// */
//public class QueryTable {
//    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addResource("Student.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        // HQL
//        List<Student> students = session.createQuery("from Student",Student.class).getResultList();
//        for (Student student: students) {
//            System.out.println("ID: " + student.getId());
//            System.out.println("Name: " +student.getName());
//            System.out.println("RollNo: " + student.getRollno());
//            System.out.println("University: " + student.getUniversity());
//        }
//        session.close();
//    }
//    /*
//    increment, generator
//    And if you don't provide any generator by default it is set to assigned.
//     */
//}
