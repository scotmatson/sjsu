import java.util.Random;

class BinaryLauncher {
    public static void main(String[] args) {

        Random random = new Random();
        int[] randInts = new int[10];

        System.out.println("Initilizing integer Array.");
        for (int i = 0; i < randInts.length; ++i) {
            randInts[i] = random.nextInt(101);
        }

        MergeSort mergeSort = new MergeSort(randInts);
        mergeSort.printArray();
        mergeSort.printSortedArray();
        
        BinarySearch binarySearch = new BinarySearch(mergeSort.getSortedArray());
        binarySearch.findValue(random.nextInt(101));
    }
}

class BinarySearch {

    BinarySearch(int[] sortedArray) {
        this.sortedArray = sortedArray;     
    }

    public void findValue(int value) {
        System.out.println("Querying Value: " + value);
        int index = findValue(this.sortedArray, 0, sortedArray.length-1, value);
        if (index >= 0) {
            System.out.println("Target value located at index " + index);
        }
        else {
            System.out.println("Target value does not exist in this array.");
        }
    }

    private int findValue(int[] sortedArray, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] > target) {
                high = mid-1; 
            }
            else if (sortedArray[mid] < target) {
                low = mid+1; 
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    private int[] sortedArray;
}

class MergeSort {

    MergeSort(int[] intArr) {
        this.intArr = intArr;
        this.sortedArray = this.sort(intArr);
    }

    public void printArray() {
        System.out.println("Elements of the Array:");
        for (int i = 0; i < intArr.length-1; i++) {
            System.out.print(intArr[i] + ", ");        
        }
        System.out.println(intArr[intArr.length-1]);
    }

    public void printSortedArray() {
        System.out.println("Elements of the Sorted Array:");
        for (int i = 0; i < sortedArray.length-1; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
        System.out.println(sortedArray[sortedArray.length-1]);
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    private int[] sort(int[] intArr) {
        int temp[] = new int[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            temp[i] = intArr[i];
        }

        sort(temp, 0, temp.length-1);
        return temp;
    }

    private void sort(int[] temp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(temp, low, mid);
            sort(temp, mid+1, high);
            merge(temp, low, mid, high);
        }
    }

    private void merge(int[] temp, int low, int mid, int high) {
        int[] t = new int[temp.length];
        for (int i = low; i <= high; i++) {
           t[i] = temp[i]; 
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {

            if (t[i] <= t[j]) {
                temp[k] = t[i];
                i++;
            }
            else {
                temp[k] = t[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = t[i];
            k++;
            i++;
        }
    }

    private int[] intArr;
    private int[] sortedArray;
}
