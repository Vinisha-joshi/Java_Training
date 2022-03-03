package Assignment3;

public class customThread extends Thread {
   private double a[][];
    private double b[][];

    public customThread(double[][] a, double[][] b, int row, int col) {
        this.a = a;
        this.b = b;
        this.row = row;
        this.col = col;
    }

    private int row;
    private int col;


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public double[][] getB() {
        return b;
    }

    public void setB(double[][] b) {
        this.b = b;
    }
    public void run() {
         double sum[][]=new double[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                sum[i][j] = a[i][j] + b[i][j];
                System.out.print(sum[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
