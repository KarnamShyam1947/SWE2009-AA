package lab3;

import utils.ArrayUtils;

public class MergeSort {

    public static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;

            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, begin, mid, end);
        }
    }

    public static void merge(int[] arr, int begin, int mid, int end) {
        int leftArrSize = mid - begin + 1;
        int rightArrSize = end - mid;

        int[] leftArr = new int[leftArrSize];
        for (int i = 0; i < leftArrSize; i++) 
            leftArr[i] = arr[begin + i];
        
        int[] rightArr = new int[rightArrSize];
        for (int i = 0; i < rightArrSize; i++) 
            rightArr[i] = arr[mid + 1 + i];
            
        int i = 0, j = 0, k = begin;
        
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        } 
        
        while (i < leftArrSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < rightArrSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.inputArray();

        ArrayUtils.printArray(arr, "Before Sorting : ");

        mergeSort(arr, 0, arr.length - 1);

        ArrayUtils.printArray(arr, "After Sorting  : ");
    }
}
