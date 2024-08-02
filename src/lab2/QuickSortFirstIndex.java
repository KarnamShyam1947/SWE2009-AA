package lab2;

import java.util.Arrays;
import java.util.Scanner;

import utils.ArrayUtils;

public class QuickSortFirstIndex {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getPivot(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int i = begin + 1;

        for (int j = begin + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, begin, i - 1);
        return i - 1;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = getPivot(arr, begin, end);

            quickSort(arr, begin, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = ArrayUtils.inputArray();

        System.out.print("\nBefore Sorting : ");
        System.out.println(Arrays.toString(arr));
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.print("After  Sorting : ");
        System.out.println(Arrays.toString(arr));
        
        input.close();
    }
}
