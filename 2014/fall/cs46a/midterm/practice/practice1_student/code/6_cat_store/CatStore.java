/*
 * This class represents a store that sells cats.  When you create a new cat store, you start off with a certain number of cats
 * including some cats that are pregnant (or expecting).  The number of cats that you have will change as your cats have kittens
 * and as you sell cats.
 */

/**
 * @author natalie.linnell@sjsu.edu
 */
public class CatStore
{

    //instance variables
    private int numCats;
    private int numExpecting;
    private int numKittens;
    private int numLitters;

    /**
     * Create a cat store starting off with a certain number of cats, with some of them expecting 
     * @param cats - the number of cats
     * @param expecting - the number of cats that are expecting (pregnant)
     */
    public CatStore(int cats, int expecting)
    {
        numCats = cats;
        numExpecting = expecting;
        numLitters = 0;
        numKittens = 0;
    }

    /**
     * One of your cats has kittens
     * @param litterSize - the number of kittens that have been born.
     */
    public void haveKittens(int litterSize)
    {
        numExpecting = numExpecting - 1;
        numKittens = numKittens + litterSize;
        numLitters = numLitters + 1;
        numCats = numCats + litterSize;
    }

    /**
     * One of your cats becomes pregnant
     * 
     */
    public void anotherExpecting()
    {
        numExpecting = numExpecting +1;
    }

    /**
     * You sell a cat.  The parameter tells you whether or not the cat you sold was expecting
     * @param expecting - a boolean that says whether or not the cat was expecting.
     */
    public void sellCat(boolean expecting)
    {
        numCats = numCats - 1;
        if(expecting)
        {
            numExpecting = numExpecting - 1;
        }
    }

    /**
     * This method returns the total number of kittens that have been born since you started your cat store.
     * @return integer - the total number of kittens
     */
    public int getNumKittens()
    {
        return numKittens;
    }

    /**
     * This method returns the number of times a cat has given birth in your cat store (the total number of litters)
     * @return integer - the total number of litters of kittens
     */
    public int getNumLitters()
    {
        return numLitters;
    }

    /** 
     * This method returns the total number of cats in the cat store
     * @return integer - the total number of cats 
     */
    public int getNumCats()
    {
        return numCats;
    }

    /**
     * This method returns the total number of cats in the store that are currently pregnant (expecting)
     * @return integer - the number of cats that are expecting.
     */
    public int getNumExpecting()
    {
        return numExpecting;
    }
}