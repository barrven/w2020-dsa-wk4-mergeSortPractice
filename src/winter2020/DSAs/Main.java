package winter2020.DSAs;

import java.util.Scanner;

public class Main {

    public static void mergeSort(int[] a, int n, Counter c) {

        if (n == 1) return; //base case
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid]; //difference between left half and remaining half

        for (int i = 0; i < mid; i++) { //copy left and right halves of a[]
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        System.out.println("step" + c.count() + " s(n=" + n + ")" + "\t\t\tL=" + arrToString(l) + " R=" + arrToString(r));

        mergeSort(l, mid, c);
        //System.out.println("---------------");

        mergeSort(r, n - mid, c);
        //System.out.println("---");

        merge(a, l, r, mid, n - mid, c);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right, Counter c) {

        // i = counter for l, j = counter for r, k = counter for a
        int i = 0, j = 0, k = 0; //these are incremented separately when an item is copied
        while (i < left && j < right) {
            if (l[i] <= r[j]) { // if the element on the right side is less than on the right, copy into a[]
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++]; //otherwise, take element from the right
            }
        }
        while (i < left) { //covers the case where all elements from right are gone, but left is still there
            a[k++] = l[i++];
        }
        while (j < right) { //covers the case where left is empty but right is not
            a[k++] = r[j++];
        }
        System.out.println("step" + c.count() + " m(L=" + arrToString(l) + " R=" + arrToString(r) + ")");
        System.out.println("\t\t\t\t\t\tA: " + arrToString(a));
    }

    //==================================================================================================================

    public static void main(String[] args) {
	    int[] arr = {10,6,8,5,7,3,4};
	    int n = arr.length;

//	    printArr(arr);
//      System.out.println("==============");
//      Counter c = new Counter();
//      mergeSort(arr, n, c);

        SortSearchPracticeClass items = new SortSearchPracticeClass(100);
        items.populateItems(arr);
        items.printItems();
        //items.mSort();
        //items.insertionSort();
        items.selectionSort();
        items.printItems();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter search term: ");
        int x = in.nextInt();
        System.out.println("Number "+ x + " is at index " + items.binarySearch(x));

    }

    //==================================================================================================================



    public static void printArr(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static String arrToString(int[] arr){
        StringBuilder s = new StringBuilder();
        s.append("[");
        int n = arr.length;
        for (int i = 0; i < n; i++){
            s.append(arr[i]).append(" ");
        }
        s.append("]");
        return s.toString();
    }
}
