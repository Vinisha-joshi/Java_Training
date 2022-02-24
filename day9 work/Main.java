package day7;

import day8.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Person person = new Person(1, "name-1", "address-1");
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addAnnotatedClass(Person.class);
//        configuration.addResource("Person.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(person);
//        transaction.commit();
//        session.close();
//        Car car = new Car(50.777,"BMw",2.4f,'v',true, 2777L);
//
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addAnnotatedClass(Car.class);
//        configuration.addResource("Car.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.persist(car);
//       // session.persist(car1);
//        session.persist(car);
//        transaction.commit();
//        session.close();
//        Student student1 = new Student("Vinisha",11,"rgpv");
//        Student student2 = new Student("Vini",12,"rgpv");
//        Student student3 = new Student("Vinit",13,"rgpv");
        Person person1=new Person("Vinisha",true);
        Person person2=new Person();
        person2.setName("Vini");
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person1);
        session.persist(person2);
        transaction.commit();
        session.close();

    }
}
