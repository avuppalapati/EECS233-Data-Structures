package amv87.myCode;

import java.util.Arrays;

public class Sorting {

    // empty constructor
    public Sorting() {

    }

    public static void mergeSort(int[] arr) {
        /*
            i is how big the "subarray" is
            "subarray" is in quotes b/c there is no actual subarray being created
            it is just the index of the current array to represent what would be a subarray in the original mergeSort
         */
        for (int i = 1; i <= arr.length - 1; i = 2 * i) {
            /*
            j is where you start on the left "subarray"
            "subarray" is in quotes b/c there is no actual subarray being created
            it is just the index of the current array to represent what would be a subarray in the original mergeSort
         */
            for (int j = 0; j <= arr.length - 1; j = i * 2 + j) {
                // leftStart is the start of the left "subarray"
                int leftStart = j;
                // leftEnd is the end of the left "subarray"
                //int leftEnd = leftStart + i - 1;
                int leftEnd = Integer.min(leftStart + i - 1, arr.length - 1);
                // rightStart is the start of the right "subarray"
                int rightStart = leftStart + i;
                // rightEnd is the end of the right "subarray"
                int rightEnd = Integer.min(leftStart + 2 * i - 1, arr.length - 1);

                // creates a temp array
                int[] tempArr = new int[arr.length];
                //int[] tempArr = new int[leftEnd - leftStart + 1];

                sorting(arr, leftStart, leftEnd, rightStart, rightEnd, tempArr);
                //System.out.println(Arrays.toString(tempArr));
                sorting(tempArr, leftStart, leftEnd, rightStart, rightEnd, arr);
                //System.out.println(arr);

            }
        }
    }

    // this is the sorting method
    // these are temporary variables that are used to just iterate through and compare properly
    private static void sorting(int[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd, int[] tempArr) {
        int k = leftStart, l = rightStart, tempInd = leftStart;
        while (k < leftEnd - leftStart + 1 && l < rightEnd - leftEnd) {
            // compares the index of the left "subarray" to the right "subarray"
            // puts the smaller one in the temp-array
            if (arr[k] <= arr[l]) {
                // sorts the original array into the temp array to avoid back-copying
                tempArr[tempInd] = arr[k];
                //arr[k] = tempArr[tempInd];
                k++;
            }
            else {
                // sorts the original array into the temp array to avoid back-copying
                tempArr[tempInd] = arr[l];
                // arr[l] = tempArr[tempInd];
                l++;
            }
            tempInd++;
        }

        while (k < leftEnd - leftStart + 1) {
            //arr[k] = tempArr[tempInd];
            tempArr[tempInd] = arr[k];
            k++;
            tempInd++;
        }

        while (l < rightEnd - leftEnd) {
            //arr[l] = tempArr[tempInd];
            tempArr[tempInd] = arr[l];
            l++;
            tempInd++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 2, 7, 7, 1, 5, 7, 6};
        //int arr[] = {12, 11, 13, 5, 7, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
