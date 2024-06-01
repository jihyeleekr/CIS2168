import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        int[] arr1 = {9,8,7,6,5,43,2,1};
        int[] arr2 = {23,45,78,98,1,34,30,67};
        int[] arr3 = {29,56,78,92,34,71,2,7,9};

        // Merge Sort
        MergeSort mergeSort = new MergeSort();

        // Merge Sort for arr 1
        System.out.println("Merge Sort for arr1: ");
        mergeSort.mergeSort(arr1, 0, arr1.length-1);

        // Merge Sort for arr 2
        System.out.println("\nMerge Sort for arr2: ");
        mergeSort.mergeSort(arr2, 0, arr2.length-1);

        // Merge Sort for arr 3
        System.out.println("\nMerge Sort for arr3: ");
        mergeSort.mergeSort(arr3, 0, arr3.length-1);

        // Quick Sort
        quickSort test = new quickSort();
        // First Pivot Sort
        System.out.println("\nFirst Pivot for prob 1");
        test.first_Pivot(arr1);

        System.out.println("\nFirst Pivot for prob 2");
        test.first_Pivot(arr2);

        System.out.println("\nFirst Pivot for prob 3");
        test.first_Pivot(arr3);


        // Last Pivot Sort
        System.out.println("\nLast Pivot for test 1");
        test.last_Pivot(arr1);

        System.out.println("\nLast Pivot for test 2");
        test.last_Pivot(arr2);

        System.out.println("\nLast Pivot for test 3");
        test.last_Pivot(arr3);

        // Mid Pivot Sort
        System.out.println("\nMid Pivot for test 1");
        test.mid_Pivot(arr1);

        System.out.println("\nMid Pivot for test 2");
        test.mid_Pivot(arr2);

        System.out.println("\nMid Pivot for test 3");
        test.mid_Pivot(arr3);

        // Heap Sort

        HeapSort heap = new HeapSort();

        System.out.println("\nHeap Sort:");
        heap.sort(arr1);

        System.out.println("\nHeap Sort:");
        heap.sort(arr2);

        System.out.println("\nHeap Sort:");
        heap.sort(arr3);

    }


}