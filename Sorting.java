/**
 * Sorting
 */
public class Sorting {

    public static boolean isSorted(int[] arr) {
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return sorted;
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.round(Math.random() * 200);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    public static void print(int[] arr) {
        String s = "{";
        for (int i = 0; i < arr.length - 1; i++) {
            s += arr[i] + ", ";
        }
        s += arr[arr.length - 1] + "}";
        System.out.println(s);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leastIndex = i;
            int leastElement = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < leastElement) {
                    leastElement = arr[j];
                    leastIndex = j;
                }
            }
            swap(arr, leastIndex, i);
        }

    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }

    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] a1 = new int[mid - low + 1];
        int[] a2  = new int[high - mid];

        for (int i = 0; i < a1.length; i++) {
            a1[i] = arr[low + i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = arr[mid + 1 + i];
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < a1.length && p2 < a2.length) {
            if (a1[p1] < a2[p2]) {
                arr[low] = a1[p1];
                p1++;
            } else {
                arr[low] = a2[p2];
                p2++;
            }
            low++;
        }
        while (p1 < a1.length) {
            arr[low] = a1[p1];
            p1++;
            low++;
        }
        while (p2 < a2.length) {
            arr[low] = a2[p2];
            p2++;
            low++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        // choosing high as the pivot
        int pivot = arr[high];
        int cursor = low;
        // this works by finding the correct index for a selected pivot
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                swap(arr, cursor, i);
                cursor++;
            }
        }
        swap(arr, high, cursor);
        return cursor;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr = generateRandomArray(20);
            System.out.println("-".repeat(50));
            System.out.println("Array " + (i + 1) + " Unsorted: ");
            print(arr);
            System.out.println("Is this sorted? --> " + isSorted(arr));
            // selectionSort(arr);
            // bubbleSort(arr);
            // insertionSort(arr);
            // mergeSort(arr, 0, arr.length - 1);
            quickSort(arr, 0, arr.length - 1);
            System.out.println("Array " + (i + 1) + " Sorted: ");
            print(arr);
            System.out.println("Is this sorted? --> " + isSorted(arr));
            System.out.println("-".repeat(50));
        }
    }
}