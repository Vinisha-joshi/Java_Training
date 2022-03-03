package Assignment3;

public class Que3 {
    public static void main (String[] args) {
        int[] arr1 = {12, 34, 66, 75};
        int[] arr2 = {1, 5, 19, 50, 89, 100};
        int[] arr3 = new int[arr1.length + arr2.length];
        mergeArray(arr1,arr2,arr3);
    }

    public static void mergeArray(int[] arr1, int[] arr2, int[] arr3) {
        int l1=arr1.length;
        int l2=arr2.length;
        int i = 0, j = 0, k = 0;
        while (i<l1 && j <l2)
        {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < l1)
            arr3[k++] = arr1[i++];
        while (j < l2)
            arr3[k++] = arr2[j++];
    }
}

