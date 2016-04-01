import java.util.Random;

class HammingLauncher {
    public static void main(String[] args) {

        Random random = new Random();

        System.out.println("Initilizing integer values.");
        int int1 = random.nextInt(1001);
        int int2 = random.nextInt(1001);

        HammingDistance hammingDistance = new HammingDistance(int1, int2);
        hammingDistance.getDistance();
    }
}

class HammingDistance {

    HammingDistance(int int1, int int2) {
        this.int1 = int1;
        this.int2 = int2;
    }

    public int getDistance() {
        System.out.println("Evaluating distance between values:");
        BinaryHelper binaryHelper = new BinaryHelper();
        binaryHelper.binaryPrinter(this.int1);
        binaryHelper.binaryPrinter(this.int2);

        if (binaryHelper.compareBitLength(this.int1, this.int2)) {
            int xor = this.int1 ^ this.int2;
            int distance = 0;
            while (xor > 0) {
                if ((xor & 1) > 0) {
                    distance += 1;
                }
                xor >>= 1;
            }
            System.out.println("Hamming distance: " + distance);
            return distance;
        }

        System.out.println("Unequal binary length. Unable to compute.");
        return -1;
    }

    private class BinaryHelper {

        public boolean compareBitLength(int a, int b) {
            int bitLengthA = 0;
            int bitLengthB = 0;
            while (a > 0) {
                bitLengthA += 1;
                a >>= 1;
            }

            while (b > 0) {
                bitLengthB += 1;
                b >>= 1;
            }

            if (bitLengthA == bitLengthB) {
                return true;
            }

            return false;
        }

        public void binaryPrinter(int n) {
            while (n > 0) {
                if ((n & 1) > 0) {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
                n >>= 1;
            }
            System.out.println();
        }
    }

    private int int1;
    private int int2;
}
