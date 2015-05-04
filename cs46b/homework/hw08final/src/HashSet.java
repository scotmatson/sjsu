public class HashSet
{
    Node[] Data;
    private static final int INITIAL_SIZE = 23;

    public HashSet()
    {
        Data = new Node[INITIAL_SIZE];
    }

    public void add(Object NewData)
    {
        HashSet_Methods.add(NewData, Data);
    }

    public int contains(Object SearchData)
    {
        return HashSet_Methods.contains(SearchData, Data);
    }
    public boolean containsBool(Object SearchData)
    {
        return (HashSet_Methods.contains(SearchData, Data) == -1) ? false : true;
    }


    public void remove(Object RemoveData)
    {
        HashSet_Methods.remove(RemoveData, Data);
    }

    public double calculateLoad()
    {
        return HashSet_Methods.calculateLoad(Data);
    }

    public void reallocate()
    {
        Data = HashSet_Methods.resize(Data);
    }
}