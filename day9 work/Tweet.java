package day9;

import jakarta.persistence.*;

@Entity
@Table(name = "Tweets")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String userId;
    private String tweet;

    public Tweet() {
    }

    public Tweet(int id, String userId, String tweet) {
        this.id = id;
        this.userId = userId;
        this.tweet = tweet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}