package Twitter_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class FollowDaoImpl implements FollowDao {
    private Session session;
    FollowDaoImpl(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Follow.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    @Override
    public List<Object[]> readAll() {
        List<Object[]> list = session.createQuery("select email,userEmail from Follow ",Object[].class ).getResultList();
        return list;
    }

    @Override
    public List<Follow> readByEmail(String email) {
        String hql = "from Follow where email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public void create(Follow follow) {
        Transaction transaction = session.beginTransaction();
        session.persist(follow);
        transaction.commit();
    }
}
