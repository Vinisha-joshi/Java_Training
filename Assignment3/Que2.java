package Assignment3;

public class Que2 {

    public static void main(String a[]){
        int[] arr = {10,5,6,33,55,22,44,88,23};
        sortArray(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void sortArray(int arr[]) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;

            }
            arr[i+1] = key;
        }
    }
}
