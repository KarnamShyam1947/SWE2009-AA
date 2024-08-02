package utils;

import java.util.Scanner;

public class ArrayUtils {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
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

}
