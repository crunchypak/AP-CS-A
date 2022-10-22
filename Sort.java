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
    public void selectionSort() {
         int startIdx = 0;
         int endIdx = arr.length - 1;
         int minIdx;
         while(startIdx != endIdx) {
             minIdx = startIdx;
             for(int i = startIdx; i < arr.length; i++) {
                 if(arr[minIdx] > arr[i]) {
                     minIdx = i;
                 }
             }
             swap(minIdx, startIdx);
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
        int[] arr = {24, 21, 0, 99};
        Sort a = new Sort(arr);
        System.out.println(a);
        a.selectionSort();
        System.out.println(a);
    }
}
