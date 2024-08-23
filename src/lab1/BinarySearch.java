package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    private static final int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) 
                return mid;

            else if (arr[mid] < target) 
                left = mid + 1;

            else
                right = mid - 1;
        }
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

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int answer = binarySearch(arr, target);

        if (answer != -1) 
            System.out.println("Target found at index : "+ answer);
        
        else
            System.out.println("Target not found in the array");

        input.close();
    }
}
