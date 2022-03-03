package Assignment3;

public class Que5 {
    public static void main(String[] args) {
        double a[][]={{1.6,2.3,3.8},{2.2,3.3,4.8}};
        double b[][]={{2.6,3.5,4},{4,5,6}};
        int row=2,col=3;
        customThread obj=new customThread(a,b,row,col);
        obj.start();

    }
}

