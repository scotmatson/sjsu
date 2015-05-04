public class Potion
{
    private double Size;
    private int Type; // 0, 1, 2, 3 ... etc. A flag value.

    public Potion(double NewSize, int NewType)
    {
        Size = NewSize;
        Type = NewType;
    }

    public double getSize() { return Size; }
    public void setSize(double size) { Size = size; }
    public int getType() { return Type; }
    public void setType(int type) { Type = type; }

    @Override
    public int hashCode() {
        final int prime = 3;
        int result = 1;

        result *= (prime * (int) getSize());
        result *= (prime * getType());

//        hashCodeTester(result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null) {
            // Testing reflexive relation
            if (this == obj) return true;

            // Testing for class symmetry
            if (this.getClass() != obj.getClass()) return false;

            Potion other = (Potion) obj;

            // Testing member relationships
            if (this.getSize() == other.getSize())
                if (this.getType() == other.getType())
                    return true;
        }
        return false;
    }

//    public void hashCodeTester(int hash) {
//        System.out.println("hashCode: " + hash);
//    }
}
