package Hibernate_Assignment.Que10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDrive {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Store.class);
        configuration.addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Store store = new Store();
        store.setName("store-1");
        store.setAddress("address-1");
        Store store2 = new Store();
        store2.setName("store-2");
        store2.setAddress("address-2");
        Store store3 = new Store();
        store3.setName("store-3");
        store3.setAddress("address-3");

        Product product = new Product();
        product.setName("Product-1");
        product.setStore(store);
        Product product1 = new Product();
        product1.setName("Product-2");
        product1.setStore(store);
        Product product2 = new Product();
        product2.setName("Product-2");
        product2.setStore(store2);

        session.persist(store);
        session.persist(store3);
        session.persist(store2);
        session.persist(product);
        session.persist(product1);
        session.persist(product2);
        transaction.commit();
        session.close();
        //insertInitial();
        //deletePerson();
        //insertNewPhoneNumber();
    }
}