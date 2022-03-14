package Spring_Assignment.Que1;

public class Database extends Thread {
    private String mySqlUrl;
    private String username;
    private String password;
    private static Database database=null; //lazy loading
    //private static Database database=new Database();//eager loading

    public Database()
    {

    }

    public Database(String mySqlUrl, String username, String password) {
        this.mySqlUrl = mySqlUrl;
        this.username = username;
        this.password = password;
    }

    //lazy loading
    public static Database getInstance(String mySqlUrl, String username, String password)
    {
        if(database==null)
        {
            database=new Database(mySqlUrl,username,password);
        }
        return database;
    }


}
