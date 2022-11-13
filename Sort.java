import java.util.Random;
/**
 * This class contains the selection, insertion, and merge sorting algorithms.
 *
 * @author Reyna
 * @version October, 2022
 */
public class Sort
{
    private int[] arr;
    public Sort(int[] arr) {
        this.arr = arr;
    }
    /**
     * This method sorts the contents of an integer array using a recursive merge sort.
     */
    public void mergeSort() {
        int[] temp = new int[arr.length];
        if(arr.length > 1) {
            mergeSortR(0, arr.length - 1, temp);
        }
        
        
    }
    private void mergeSortR(int startIdx, int endIdx, int[] temp) {
        if(startIdx == endIdx) {
            return;
        }
        int midIdx = (startIdx + endIdx) / 2;
        mergeSortR(startIdx, midIdx, temp);
        mergeSortR(midIdx + 1, endIdx, temp);
        merge(startIdx, midIdx, endIdx, temp);
    }
    private void merge(int startIdx, int midIdx, int endIdx, int[] temp) {
        int leftIdx = startIdx;
        int rightIdx = midIdx + 1;
        int tempIdx = startIdx;
        //compares the values on the right side and left side as long as both arrays contain items
        while(leftIdx <= midIdx && rightIdx <= endIdx) {
            if(arr[leftIdx] < arr[rightIdx]) {
                temp[tempIdx] = arr[leftIdx];
                leftIdx++;
            }
            else {
                temp[tempIdx] = arr[rightIdx];
                rightIdx++;
            }
            tempIdx++;
        }
        //if left side is empty, copy over rest from right side into temp
        if(leftIdx > midIdx) {
            while(rightIdx <= endIdx) {
                temp[tempIdx] = arr[rightIdx];
                tempIdx++;
                rightIdx++;
            }
        }
        //otherwise, if right side is empty, copy over rest from left side into temp
        else if(rightIdx > endIdx) {
            while(leftIdx <= midIdx) {
                temp[tempIdx] = arr[leftIdx];
                tempIdx++;
                leftIdx++;
            }
        }
        //if both sides empty, do nothing
        //overwrite the merged portion
        int idx = startIdx;
        while(idx <= endIdx) {
            arr[idx] = temp[idx];
            idx++;
        }
    }
    /**
     * This method sorts the contents of an integer array using selection sort.
     */
    public void selectionSort() {
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int minIdx;
        while(startIdx != endIdx) {
            //find smallest number in the window
            minIdx = startIdx;
            for(int i = startIdx; i < arr.length; i++) {
                if(arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }
            //swap smallest number with first number in the window
            swap(minIdx, startIdx);
            //shift start of window
            startIdx++;
        }
    }

    /**
     * This method sorts the contents of an integer array using insertion sort.
     */
    public void insertionSort() {
        int temp;
        int j;
        for(int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for(j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    private void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public String toString() {
        String arrayStr = "";
        for(int num : arr) {
            arrayStr += num + " ";
        }
        return arrayStr;
    }

    public static void main(String[] args) {
        
        final int N = 7;
        int[] arr = new int[N];
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++) {
        arr[i] = rand.nextInt(90) + 10;
        }
        
        //int[] arr = {4, 6, 2, 7, 5, 3, 1};

        Sort a = new Sort(arr);
        System.out.println(a);
        //a.selectionSort();
        //a.insertionSort();
        a.mergeSort();
        System.out.println(a);
    }
}
