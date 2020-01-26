package winter2020.DSAs;
import org.jetbrains.annotations.NotNull;

public class SortSearchPracticeClass {
    int numItems;
    int maxItems;
    int[] items;

    public SortSearchPracticeClass(int maxItems){
        this.maxItems = maxItems;
        numItems = 0;
        items = new int[maxItems];
    }

    public void mSort(){
        mergeSort(items, numItems);
    }

    private void mergeSort(int[] a, int n){
        if (n == 1) return;
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        for (int i = 0; i < mid; i++){
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++){
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n-mid);
        merge(a, l, r, mid, n-mid);
    }

    private void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (l[i] <= r[j]) a[k++] = l[i++];
            else a[k++] = r[j++];
        }
        while (i < left){
            a[k++] = l[i++];
        }
        while (j < right){
            a[k++] = r[j++];
        }
    }

    public void insertionSort(){
        for (int i = 1; i < numItems; i++){
            int temp = items[i];
            int j = i-1;
            while (j > -1 && items[j] > temp){
                items[j+1] = items[j];
                j--;
            }
            items[j+1] = temp;
        }
    }

    public void selectionSort(){
        for (int i = 0; i < numItems-1; i++){
            int sm = i;
            for (int j = i+1; j < numItems; j++){
                if (items[j] < items[sm]) sm = j;
            }
            int temp = items[i];
            items[i] = items[sm];
            items[sm] = temp;
        }
    }

    public int binarySearch(int key){
        int first = 0, mid, last = numItems-1;
        System.out.println(numItems);
        while (first <= last){
            mid = (first + last) / 2;
            if (items[mid] == key) return  mid;
            if (items[mid] < key) first = mid+1;
            else last = mid-1;
        }
        return -1;
    }










    //------------------------------------------------------------------------------------------------------------------
    public void populateItems(@NotNull int[] list){
        int smaller = list.length;
        if (smaller > maxItems) smaller = maxItems;
        for (int i = 0; i < smaller; i++){
            items[i] = list[i];
            numItems++;
        }
    }

    public String itemsToString(){
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for (int i = 0; i < numItems; i++){
            s.append(items[i]).append(" ");
        }
        s.append("]");
        return s.toString();
    }

    public void printItems(){
        System.out.print("[ ");
        for (int i = 0; i < numItems; i++){
            System.out.print(items[i] + " ");
        }
        System.out.print("]\n");
    }
}
