import java.util.Scanner;
public class Search
{
    /**
     * This method uses linear search.
     * @param arr This is the list of integers to search from
     * @param target This is the integer to search for
     * @return Whether the target was found or not
     */
    public static boolean linearSearch(int[] arr, int target) {
        for(int num : arr) {
            if(num == target) {
                return true;
            }
        }
        return false;
    }
    /**
     * This method uses a non-recursive binary search.
     * @param arr This is the list of integers to search from
     * @param target This is the integer to search for
     * @return The index of where the target was found, or -1 if not found
     */
    public static int binarySearchNonRecursive(int[] arr, int target) {
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int midIdx = arr.length / 2;
        while(startIdx <= endIdx) {
            if(arr[midIdx] == target) {
                return midIdx;
            }
            //left side
            else if(target < arr[midIdx]) {
                endIdx = midIdx - 1;
            }
            //right side
            else{
                startIdx = midIdx + 1;
            }
            midIdx = startIdx + (endIdx - startIdx + 1) / 2;
        }
        return -1;
    }
    /**
     * This method uses a recursive binary search.
     * @param arr This is the list of integers to search from
     * @param target This is the integer to search for
     * @return Whether the target was found or not
     */
    public static boolean binarySearchRecursive(int[] arr, int target) {
        return binarySearchR(arr, target, 0, arr.length-1);
    }
    /*
     This is the private recursive method
     @param arr This is the list of integers to search from
     @param target This is the integer to search for
     @param startIdx This is the array index of the beginning of the search window
     @param endIdx This is the array index of the end of the search window
     @return Whether the target was found or not
    */
    private static boolean binarySearchR(int[] arr, int target, int startIdx, int endIdx) {
        if(startIdx > endIdx) {
            return false;
        }
        int midIdx = (startIdx + endIdx)/2;
        int midVal = arr[midIdx];
        if(target == midVal) {
            return true;
        }
        else if(target > midVal) {
            startIdx = midIdx + 1;
        }
        else{
            endIdx = midIdx - 1;
        }
        return binarySearchR(arr, target, startIdx, endIdx);
    }
    
    public static void main(String[] args) {
        int[] arr = {25,27,34,46,53,64,78,79,81,99};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer to search for: ");
        int target = sc.nextInt();
        //boolean found = Search.linearSearch(arr, target);
        //int foundIdx = Search.binarySearchNonRecursive(arr, target);
        boolean foundIdx = Search.binarySearchRecursive(arr, target);
        if(foundIdx) {
            System.out.println(target + " is in the list");
        }
        else{
            System.out.println(target + " is not in the list");
        }
    }
}
