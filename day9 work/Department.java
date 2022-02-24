package day9;

public class Department {
    private int did;

    Department(){

    }
    public Department( String dep_Name) {

        Dep_Name = dep_Name;
    }

    private String Dep_Name;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
    public String getDep_Name() {
        return Dep_Name;
    }

    public void setDep_Name(String dep_Name) {
        Dep_Name = dep_Name;
    }


}
