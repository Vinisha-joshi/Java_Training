package Hibernate_Assignment;
import day8.Product1;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Que4 {
    /*
        CRUD-->Create,Read,Update,Delete
     */
    public static void main(String[] args) {
        getSession();
        //  updateExample();
        //readExample();
        //deleteExample();
        //insertData();
    }
    // Read
    private static void readExample() {
        Session session = getSession();
        List<Product1> personList = session.createQuery("from Product", Product1.class).getResultList();
        for(Product1 product1 :personList)
        {
            if(product1.getAmount()>100)
            {
                System.out.println("Name : "+ product1.getName());
                System.out.println("Amount : "+ product1.getAmount());
            }
        }
        session.close();
    }

    // D
    private static void deleteExample() {
        Session session = getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("delete Product where amount < 10");
        int result = query.executeUpdate();
        transaction.commit();
    }
    // Create
    private static void insertData() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Product1 product = new Product1("name-1",200);
        Product1 product1 = new Product1("name-2",2);
        Product1 product12 = new Product1("name-3",10);
        Product1 product13 = new Product1("name-4",1000);
        Product1 product14 = new Product1("name-4",-22);
        session.persist(product);
        session.persist(product1);
        session.persist(product12);
        session.persist(product13);
        session.persist(product14);
        transaction.commit();
    }
    // Update
    private static void updateExample(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addResource("Product.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Product set amount=10 where amount < 0");
        int result = query.executeUpdate();

        transaction.commit();



    }
    private static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addResource("Product.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

}
