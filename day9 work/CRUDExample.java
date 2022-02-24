package day8;
import day7.Person;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
//Q--) Create a table Product with
//        id,
//        name,
//        amount
//        User hibernate CRUD operations to do the following:
//        1) Insert dummy data into it
//        (i) include data with amount <0
//        (ii) include data with amount = 1 ,2 3
//        (iii) include data with amount = 100, 200, 300
//        2) print all the entries which has amount > 100
//        3) update the entries which has amount < 0 to amount =10
//        4) delete all entries which has amount <10
//        and print out the entries
//        */
public class CRUDExample {
    public static void main(String[] args) {
        updateExample();

    }
    // R
    private static void readExample() {
        Session session = getSession();
        List<Product> personList = session.createQuery("from Product",Product.class).getResultList();
       for(Product product:personList)
       {
           if(product.getAmount()>100)
           {
               System.out.println("Name : "+product.getName());
               System.out.println("Amount : "+product.getAmount());
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
    // C
    private static void insertData() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Product product = new Product("name-1",200);
       Product product1 = new Product("name-2",2);
       Product product2 = new Product("name-3",10);
       Product product3 = new Product("name-4",1000);
        Product product4 = new Product("name-4",-22);
        session.persist(product);
       session.persist(product1);
       session.persist(product2);
       session.persist(product3);
        session.persist(product4);
        transaction.commit();
    }
    // U
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