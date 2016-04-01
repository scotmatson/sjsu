import java.util.Random;

class BubbleLauncher {
    public static void main(String[] args) {

        Random random = new Random();
        int[] randInts = new int[10];

        System.out.println("Initilizing integer Array.");
        for (int i = 0; i < randInts.length; ++i) {
            randInts[i] = random.nextInt(100)+1;
        }

        BubbleSort bubbleSort = new BubbleSort(randInts);
        bubbleSort.printArray();
        bubbleSort.printSortedArray();
    }
}

class BubbleSort {

    BubbleSort(int[] intArr) {
        this.intArr = intArr;
        this.sortedArray = this.sort(intArr);
    }

    public void printArray() {
        System.out.println("Elements of the Array:");
        for (int i = 0; i < intArr.length-1; ++i) {
            System.out.print(intArr[i] + ", ");        
        }
        System.out.println(intArr[intArr.length-1]);
    }

    public void printSortedArray() {
        System.out.println("Elements of the Sorted Array:");
        for (int i = 0; i < sortedArray.length-1; ++i) {
            System.out.print(sortedArray[i] + ", ");
        }
        System.out.println(sortedArray[sortedArray.length-1]);
    }

    private int[] sort(int[] intArr) {
        int temp[] = new int[intArr.length];

        for (int i = 0; i < intArr.length; ++i) {
            temp[i] = intArr[i];
        }

        for (int i = 0; i < temp.length; ++i) {
            for (int j = 0; j < temp.length-1; ++j) {
                if (temp[j] > temp[j+1]) {
                    temp[j] = temp[j] ^ temp[j+1];
                    temp[j+1] = temp[j] ^ temp[j+1];
                    temp[j] = temp[j] ^ temp[j+1];
                }
            }
        }
        return temp;
    }

    private int[] intArr;
    private int[] sortedArray;
}
