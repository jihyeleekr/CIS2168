import java.lang.reflect.Array;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(palen("?Kayak?"));
        int[] nums = {1, 2, 4, 4, 4, 4, 4, 4, 4, 4};
        int target = 4;
        System.out.println(binarySearchFirstOccurrence(nums, target));
        System.out.println(powerOf3(9));
        System.out.println(power (2, 3));
    }
    // Check whether String s is a palendrim or not.
    public static boolean palen(String s){
        int n = s.length();
        // check the length of the string
        if (n == 1){
            return true;
        } else{
            // if the first letter and the last letter of the s are the same then remove those two from s
            // then move to the next letter from the right and left.
            if (s.substring(0,1).equalsIgnoreCase(s.substring(n-1))){
                s = s.substring(1,n-1);
                return palen(s);
            }
            else{
                //if the length of s is not 1 and the first and the last letter are not the same
                //return false.
                return false;
            }
        }
    }

    public static int binarySearchFirstOccurrence(int[] nums, int target) {
        return binarySearchFirstOccurrence(nums, target, 0, nums.length - 1);
    }

    private static int binarySearchFirstOccurrence(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid; // Found the first occurrence of the target
                } else {
                    return binarySearchFirstOccurrence(nums, target, low, mid - 1);
                }
            } else if (nums[mid] < target) {
                return binarySearchFirstOccurrence(nums, target, mid + 1, high);
            } else {
                return binarySearchFirstOccurrence(nums, target, low, mid - 1);
            }
        }
        return -1; // Target not found in the array
    }


    // Check whether int n is a power of 3.
    public static boolean powerOf3(int n){
        if (n == 1){
            return true;
        } else if(n % 3 == 0){
            n = n /3;
            return powerOf3(n);
        }
        return false;
    }
    // return x^n
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            int halfResult = power(x, n / 2);
            return halfResult * halfResult;
        } else {
            int halfResult = power(x, (n - 1) / 2);
            return x * halfResult * halfResult;
        }
    }

}