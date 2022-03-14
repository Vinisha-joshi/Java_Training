package Spring_Assignment.Que1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    //@Scope("prototype")
    public static Database getDatabase()
    {
        System.out.println("inside getDatabase");
        Database db=new Database("url3","root3","root3");
        return db;
    }
    @Bean
    @Scope("prototype")
    public MySql getOperation()
    {
        return new operation1() ;
        }
}
