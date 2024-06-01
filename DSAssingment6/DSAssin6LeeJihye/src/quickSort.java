import java.util.Arrays;
class quickSort {
    int[] swap(int[] arr, int current, int prev){
        int temp = arr[current];
        arr[current] = arr[prev];
        arr[prev] = temp;
        return arr;
    }
    // First Pivot Sort
    void first_Pivot(int[] nums) {
        firstPivotSort(nums, 0, nums.length - 1);

    }

    void firstPivotSort(int[] nums, int start, int end) {
        // Sorting runs until it reaches the last index
        if (start < end) {
            int pivotIndex = firstPiv(nums, start, end);
            firstPivotSort(nums, start, pivotIndex - 1);
            firstPivotSort(nums, pivotIndex + 1, end);
        }
    }

    int firstPiv(int[] nums, int start, int end) {

        // State the pivot (First element in the array)
        int pivot = nums[start];
        // Starts from 1
        int i = start + 1;

        for (int j = start + 1; j <= end; j++) {
            // If the pivot's next element less than the pivot then switch the place
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, start, i - 1);
        printArray(nums);

        return i - 1;
    }

    // Last Pivot Sort
    void last_Pivot(int[] nums){
        last_PivotSort(nums, 0, nums.length-1);
    }
    void last_PivotSort(int[] nums, int start, int pivot){
        if (start < pivot){
            int index = lastPiv(nums, start, pivot);
            // Numbers that are less than pivot
            last_PivotSort(nums,start,index-1);
            // Numbers that are greater than pivot
            last_PivotSort(nums, index+1, pivot);
        }
    }

    int lastPiv(int[] nums, int start, int pivot) {
        // State pivot
        int val = nums[pivot];
        // previous pointer. Starts from -1
        int prev = start - 1;
        // current pointer(starts from the first element)
        for (int current = start; current < pivot; current++) {
            // If current pointer greater than pivot then pass
            if (nums[current] > val) {
            } else {
                // If current pointer less than pivot then increase previous pointer
                prev++;
                // If current index is greater than previous pointer then swap
                if (current > prev) {
                    swap(nums, current, prev);
                }
            }
        }

        swap(nums, pivot, prev + 1);
        printArray(nums);
        return prev + 1;
    }

    // Pivot is the mid
    void mid_Pivot(int[] nums){
        midPivotSort(nums, 0, nums.length-1);
    }

    void midPivotSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = midPiv(nums, start, end);
            midPivotSort(nums, start, pivotIndex - 1);
            midPivotSort(nums, pivotIndex + 1, end);
        }
        printArray(nums);
    }

    int midPiv(int[] nums, int start, int end) {
        // Pivot is the middle element
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        //Starts from 0
        int i = start;
        //Ends at the last index of the array
        int j = end;

        while (true) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void printArray(int[] nums) {
        for (int value : nums) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
