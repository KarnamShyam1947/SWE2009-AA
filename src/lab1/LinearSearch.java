package lab1;

import java.util.Scanner;

public class LinearSearch {

    private static final int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) 
            if (arr[i] == target) 
                return i;

        return -1;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.print("Enter size of array : ");
        size = input.nextInt();
        
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter value(%d/%d) : ", (i+1), size);
            arr[i] = input.nextInt();
        }
        
        System.out.print("Enter target value to search in array : ");
        int target = input.nextInt();

        int answer = linearSearch(arr, target);

        if (answer != -1) 
            System.out.println("Target found at index : "+ answer);
        
        else
            System.out.println("Target not found in the array");

        input.close();
    }
}

