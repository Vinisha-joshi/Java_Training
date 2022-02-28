package Hibernate_Assignment.Que7;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.factory.spi.StandardGenerator;

import java.util.Random;

public class CustomidGenerator implements StandardGenerator {
    private final String DEFAULT_SEQUENCE_NAME="my_seq";
    /*
    1) What keyword I will use in the generator xml tag
         (i) increment -> linked to the IncrementGenerator class.
     */
    static int i=0;
    @Override

    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        i++;
        return i;
        /*
        The logic for generation of custom ID
        sub1EMPID,
        sub2EMPID

        String str = "";// of length 10 starting with oracle
         */
    }
}

