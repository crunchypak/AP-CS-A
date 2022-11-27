import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
/**
 * This class contains linear and binary searches for an ArrayList of integers.
 *
 * @author RA
 * @version 1.0
 */
public class SearchArrayList
{
    private static ArrayList<Integer> arr;
    /**
     * This is a sequential search method
     * @param target The integer to search for
     * @return Returns the index where the target was found, or -1 if not found
     */
    public static int linearSearch(int target) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This is a binary search method which calls a recursive, private method
     * @param target The integer to search for
     * @return Returns the index where the target was found, or -1 if not found
     */
    public static int binarySearch(int target) {
        return binarySearchRecursive(target, 0, arr.size() - 1);
    }
    /**
     * @param target The integer to search for
     * @param startIdx The starting index of the window
     * @param endIdx The ending index of the window
     * @return Returns the index where the target was found, or -1 if not found
     */
    private static int binarySearchRecursive(int target, int startIdx, int endIdx) {
        int midIdx = (startIdx + endIdx) / 2;
        if(startIdx > endIdx) {
            return -1;
        }
        if(arr.get(midIdx) == target) {
            return midIdx;
        }
        else if(target > arr.get(midIdx)) {
            return binarySearchRecursive(target, midIdx + 1, endIdx);
        }
        else{
            return binarySearchRecursive(target, startIdx, midIdx - 1);
        }
    }
    /**
     * Test code
     */
    public static void main(String[] args) {
        final int N = 10;
        arr = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < N; i++) {
            arr.add(rand.nextInt(90) + 10);
        }
        Collections.sort(arr);
        System.out.println(arr);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a two-digit integer to search for: ");
        int target = sc.nextInt();
        System.out.println();
        //int idx = SearchArrayList.linearSearch(target);
        int idx = SearchArrayList.binarySearch(target);
        if(idx > -1) {
            System.out.println(target + " was found at index "+ idx +".");
        }
        else{
            System.out.println(target + " was not in the ArrayList.");
        }
    }
}
