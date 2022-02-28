package Hibernate_Assignment.Que9;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class CatDrive {
    public static void main(String[] args) {
        result();

    }
    public static void result()
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Hibernate_Assignment.Que9.Cat.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> critertiaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Cat> root = critertiaQuery.from(Cat.class);
        critertiaQuery.multiselect(root.get("name"),root.get("weight"),root.get("age"));
        Predicate p1=criteriaBuilder.gt(root.get("weight"),2);
        Predicate p2=criteriaBuilder.like(root.get("name"),"m%");
        critertiaQuery.where(criteriaBuilder.and(p1,p2));
        critertiaQuery.orderBy(criteriaBuilder.asc(root.get("age")));
        List<Object[]> list = session.createQuery(critertiaQuery).getResultList();

        for (Object[] object : list) {
            System.out.println(object[0] + "     " + object[1]+"      "+object[2]);

        }
    }
    public static void insertData()
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Hibernate_Assignment.Que9.Cat.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String[] names = new String[]{"mcat","bcat","acat","bcat","ccat","dcat","ecat"};
        Transaction transaction = session.beginTransaction();
        for(int i=0;i<100;i++){
            Cat cat=new Cat();
            cat.setAge((int)(Math.random()*100));
            cat.setWeight((int)(Math.random()*10));
            cat.setName(names[(int)(Math.random()*7)]);
            session.persist(cat);
        }
        transaction.commit();
        session.close();
    }
}
