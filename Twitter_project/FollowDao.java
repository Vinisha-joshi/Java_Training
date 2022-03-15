package Twitter_project;

import java.util.List;

public interface FollowDao {
     List<Object[]> readAll();
     void create(Follow follow);
    List<Follow> readByEmail(String email);
}
