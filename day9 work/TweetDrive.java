package day9;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

import java.util.List;

public class TweetDrive {
    public static void main(String[] args) {
        groupBy();
    }
    private static void insertRecordsInTweets() {
        Session session = Utility.getSession();
        String[] userId = new String[]{"userID-1","userID-2","userID-3","userID-4"};
        String[] Tweets = new String[]{"Tweet-1","Tweet-2","Tweet-3","Tweet-4"};
        Transaction transaction = session.beginTransaction();
        for(int i=0;i<100;i++){
            Tweet tweet = new Tweet();
            tweet.setUserId(userId[(int)(Math.random()*4)]);
            tweet.setTweet(Tweets[(int)(Math.random()*4)]);
            session.persist(tweet);
        }
        transaction.commit();
        session.close();
    }
    private static void groupBy(){
        Session session = Utility.getSession();
        List<?> list = session.createQuery("Select userId,count(tweet) from Tweet group by userId").list();
        for(int i=0; i<list.size(); i++) {
            Object[] arr = (Object[]) list.get(i);
            System.out.println(arr[0]+", "+ arr[1]);
        }
    }
    }


