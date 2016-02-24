
/**
 * Write a description of class CatStoreTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CatStoreTester
{
    public static void main(String[] args) {
        CatStore myStore = new CatStore(11, 6);
        myStore.sellCat(true);
        System.out.print("Ratio of expecting cats: ");
        System.out.println(myStore.getNumCats() / myStore.getNumExpecting());
        myStore.haveKittens(6);
        myStore.haveKittens(3);
        System.out.print("Average number of kittens per litter: ");
        System.out.println((double) myStore.getNumKittens() / (double) myStore.getNumLitters());
    }
}
