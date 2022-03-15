package Twitter_project;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "following")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Follow() {
    }

    @Override
    public String toString() {
        return "Follow{" +
                "email='" + email + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
    public Follow(String email, String userEmail) {
        this.email = email;
        this.userEmail = userEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String email;
    private String userEmail;
}
