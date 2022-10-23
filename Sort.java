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
        final int N = 10;
        int[] arr = new int[N];
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(90) + 10;
        }
        //int[] arr = {42, 31, 22, 20, 10};
        
        Sort a = new Sort(arr);
        System.out.println(a);
        a.selectionSort();
        System.out.println(a);
    }
}
