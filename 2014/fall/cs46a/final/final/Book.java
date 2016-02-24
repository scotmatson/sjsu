/**
 * models a book with a title and a price
 */
public class Book
{
    private String title;
    private int price;
    
    public Book(String theTitle, int price)
    {
        title = theTitle;
        this.price = price;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public String toString()
    {
        String s = "[" + getClass().getName() + ":"
           + "title="+ title + ","
           + "price=" + price + "]";
        return s;
    }
}
