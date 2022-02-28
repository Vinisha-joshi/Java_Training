package Hibernate_Assignment.Que8;



import Hibernate_Assignment.Que8.User;
import day8.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utils.Utility;

import java.util.List;

public class UserDrive {
    public static void main(String[] args) {
        // insertData();
        maxMessage();
    }
    private static void maxMessage(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Hibernate_Assignment.Que8.User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> object=session.createQuery("select userId, count(message) from User group by userId order by userId",Object[].class).getResultList();
        Long max = 0l;
        Object userId = "";
        for (int i = 0 ; i < object.size() ; i++){
            Object[] arr = object.get(i);
            Long messages = (Long) arr[1];
            if(max < messages) {
                max = messages;
                userId = arr[0];
            }
        }
        System.out.println(max);
        System.out.println(userId);
        transaction.commit();
        session.close();
    }
    public static void insertData()
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Hibernate_Assignment.Que8.User.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String[] userId = new String[]{"ID-1","ID-2","ID-3","ID-4"};
        String[] names = new String[]{"message-1","message-2","message-3","message-4","message-6","message-7","message-8"};
        Transaction transaction = session.beginTransaction();
        for(int i=0;i<100;i++){
            User user=new User();
            user.setUserId(userId[(int)(Math.random()*4)]);
            user.setMessage(names[(int)(Math.random()*8)]);
            session.persist(user);
        }
        transaction.commit();
        session.close();
    }
}

