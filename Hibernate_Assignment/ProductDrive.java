package Hibernate_Assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utils.Utility;

public class ProductDrive {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product=new Product("name-1",500);
        Product product2=new Product();
        product2.setName("name-2");
        product2.setPrice(600);

        session.persist(product);
        session.persist(product2);
        transaction.commit();
        session.close();
    }
}
