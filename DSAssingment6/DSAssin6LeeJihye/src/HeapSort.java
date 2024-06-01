class HeapSort {
    void sort(int[] arr) {
        int capacity = arr.length;
        System.out.println("Max Heap");
        // Create heap: use complete binary tree format
        for (int i = (capacity / 2) - 1; i >= 0; i--) {
            heap(arr, capacity, i);
            printArray(arr);
        }

        System.out.println("Correct the order");
        // Remove elements from the heap
        for (int i = capacity - 1; i > 0; i--) {
            // swap the root with the last element
            int root = arr[0];
            arr[0] = arr[i];
            arr[i] = root;

            // Check the order
            heap(arr, i, 0);
            printArray(arr);
        }

    }


    void heap(int[] arr, int size, int index) {
        // Define the root var
        int root = index;
        // By the formula from ppt
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // If the left child is greater than the root than swap
        if (left < size && arr[left] > arr[root]) {
            root = left;
        }
        // If the right child is greater than the root than swap
        if (right < size && arr[right] > arr[root]) {
            root = right;
        }

        if (root != index) {
            int new_root = arr[index];
            arr[index] = arr[root];
            arr[root] = new_root;

            // Repeat the process until the heap contains the correct order.
            heap(arr, size, root);
        }
    }

    void printArray(int[] nums) {
        for (int value : nums) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

