package Hibernate_Assignment.Que3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentsAnnotedDriver {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(StudentsAnnoted.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Students students=new Students("name-1",40);
        Students students1=new Students("name-2",50);
        session.persist(students);
        session.persist(students1);
        transaction.commit();
        session.close();
    }
}
