import java.util.Random;

class MaxLauncher {
    public static void main(String[] args) {

        Random random = new Random();
        int[] randInts = new int[10];

        System.out.println("Initilizing integer Array.");
        for (int i = 0; i < randInts.length; ++i) {
            randInts[i] = random.nextInt(100)+1;
        }

        Max max = new Max(randInts);
        max.printArray();
        max.printMax();
    }
}

class Max {

    Max(int[] intArr) {
        this.intArr = intArr;
        maxInt =  setMax(this.intArr);
    }

    public void printArray() {
        System.out.println("Elements of the Array:");
        for (int i = 0; i < intArr.length-1; ++i) {
            System.out.print(intArr[i] + ", ");        
        }
        System.out.println(intArr[intArr.length-1]);
    }

    public void printMax() {
        System.out.println("Maximum Integer: " + this.maxInt);
    }

    private int setMax(int[] intArr) {

        int currentMax = intArr[0];
        for (int i = 1; i < intArr.length; ++i) {
            if (intArr[i] > currentMax) {
                currentMax = intArr[i];            
            }
        }
        return currentMax;
    }

    private int intArr[];
    private int maxInt;
}


