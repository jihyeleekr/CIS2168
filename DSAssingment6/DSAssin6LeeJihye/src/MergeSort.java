class MergeSort {
    void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            // left side
            mergeSort(nums, left, middle);
            // right side
            mergeSort(nums, middle+1, right);
            //merge
            merge(nums,left,  middle , right);
        }
    }

    // left = start position & right = end Position
    void merge(int arr[], int left, int middle, int right){
        // Finding the size of the left array
        int size_left = middle - left  +1;
        int size_right = right - middle;

        // Create left and right arrays
        int Left[] = new int[size_left];
        int Right[] = new int[size_right];

        // Insert elements into the array
        for(int left_index = 0; left_index < size_left; ++left_index){
            Left[left_index] = arr[left + left_index];
        }

        for(int right_index = 0; right_index < size_right; ++right_index){
            Right[right_index] = arr[middle + 1 + right_index];
        }

        int left_start = 0;
        int right_start = 0;
        // The merge starting point is the left index
        int start = left;

        // The while loop runs until the left and right starting index hits their arrays size
        while(left_start < size_left && right_start < size_right) {
            // if Left element is less than the right then put the element into original array
            if (Left[left_start] <= Right[right_start]) {
                arr[start] = Left[left_start];
                left_start++;
                // if the right element is less than the left element then add right side element into original array
            } else {
                arr[start] = Right[right_start];
                right_start++;
            }
            start++;
        }

        while (left_start < size_left) {
            arr[start] = Left[left_start];
            left_start++;
            start++;
        }

            // Copy the remaining elements from Right array if any
        while (right_start < size_right) {
            arr[start] = Right[right_start];
            right_start++;
            start++;
        }

        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();


    }
}
