package Spring_Assignment.Que1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
       Database db= Database.getInstance("url","vinisha","root");
       Database db2=Database.getInstance("url2","root","root");
       System.out.println(db.hashCode()+"  "+db2.hashCode());
      ApplicationContext context = SpringApplication.run(Config.class, args);
       Database db3=context.getBean(Database.class);
       Database db4=context.getBean(Database.class);
        System.out.println(db3.hashCode()+" "+db4.hashCode());
      MySql operation1 = context.getBean(operation1.class);
      System.out.println("Hashcode of quicksort = "+operation1.hashCode());
       operation1 = context.getBean(operation1.class);
      System.out.println("Hashcode of quicksort2 = "+operation1.hashCode());

    }
}
