import java.util.Random;

class MinLauncher {
    public static void main(String[] args) {

        Random random = new Random();
        int[] randInts = new int[10];

        System.out.println("Initilizing integer Array.");
        for (int i = 0; i < randInts.length; ++i) {
            randInts[i] = random.nextInt(100)+1;
        }

        Min min = new Min(randInts);
        min.printArray();
        min.printMin();
    }
}

class Min {

    Min (int[] intArr) {
        this.intArr = intArr;
        minInt =  setMin(this.intArr);
    }

    public void printArray() {
        System.out.println("Elements of the Array:");
        for (int i = 0; i < intArr.length-1; ++i) {
            System.out.print(intArr[i] + ", ");        
        }
        System.out.println(intArr[intArr.length-1]);
    }

    public void printMin() {
        System.out.println("Minimum Integer: " + this.minInt);
    }

    private int setMin(int[] intArr) {

        int currentMin = intArr[0];
        for (int i = 1; i < intArr.length; ++i) {
            if (intArr[i] < currentMin) {
                currentMin = intArr[i];            
            }
        }
        return currentMin;
    }

    private int intArr[];
    private int minInt;
}


