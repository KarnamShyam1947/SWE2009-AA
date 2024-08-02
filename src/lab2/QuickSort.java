package lab2;

import java.util.Arrays;
import java.util.Scanner;

import utils.ArrayUtils;

public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getPivot(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, end, i);
        return i;
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

        ArrayUtils.printArray(arr, "\nBefore Sorting : ");
        
        quickSort(arr, 0, arr.length - 1);
        
        ArrayUtils.printArray(arr, "After  Sorting : ");
        
        input.close();
    }
}
