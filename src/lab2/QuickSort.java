package lab2;

import java.util.Scanner;

public class QuickSort {

    public static void printArray(int[] arr, String msg) {
        System.out.print(msg);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int[] inputArray() {
        Scanner input = new Scanner(System.in);

        int size;
        System.out.print("Enter size of array : ");
        size = input.nextInt();
        
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter value(%d/%d) : ", (i+1), size);
            arr[i] = input.nextInt();
        }

        input.close();

        return arr;
    }

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

        int[] arr = inputArray();

        printArray(arr, "\nBefore Sorting : ");
        
        quickSort(arr, 0, arr.length - 1);
        
        printArray(arr, "After  Sorting : ");
        
    }
}
