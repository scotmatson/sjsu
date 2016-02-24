import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Book
{
    private int number;
    private String title;
    private String text;

    public Book(int number, String title, String text)
    {
        this.number = number;
        this.title = title;
        this.text = text;
    }

    public void setNumber(int number){ this.number = number; }
    public int getNumber() { return number; }
    public void setTitle(String title){ this.title = title; }
    public String getTitle() { return title; }
    public void setText(String text){ this.text = text; }
    public String getText(){ return this.text; }

    /**
     * toString.
     *
     * Return a String representation of this instance.
     *
     * Example: Book[number=NUMBER, title=TITLE]
     */
    @Override
    public String toString()
    {
        return "Book[number="+ getNumber() + ", title=" + getTitle() + "]";
    }

    /**
     * loadFromFile.
     *
     * Load a book from a text file. The book will
     * be stored as number on the first line, then
     * title on the next line, and the rest of
     * the file will be the text.
     *
     * Example:
     *
     * 12345
     * Hyperion
     * The text of the amazing book Hyperion by
     * Dan Simmons would go here. Blah blah blah
     * this is just an example.
     *
     * If there is a FileNotFoundException, then
     * print "Error: File not found."
     *
     * If there is another exception, then print
     * "Error while loading FILENAME." where FILENAME
     * is replaced with the filename argument
     * to the method.
     *
     * @param filename the file from which to load
     * @return a Book instance created from that file
     */
    public static Book loadFromFile(String filename)
    {
        try (Scanner in = new Scanner(new File(filename))) {
            int number = Integer.parseInt(in.nextLine());
            String title = in.nextLine();
            String text = "";
            while (in.hasNextLine()) { text += in.nextLine(); }

            Book aLiteraryMasterpiece = new Book(number, title, text);
            return aLiteraryMasterpiece;

        } catch (FileNotFoundException e) {
            System.out.printf("Error: File not found.\n");
        } catch (Exception e) {
            System.out.printf("Error while loading %s.\n", filename);
        }

        return null;
    }

    /**
     * saveToFile.
     *
     * Save a book to file. Save it using the same
     * format as above. Number on the first line, then
     * title, then the remainder is the text.
     *
     * If there is an exception then print
     * "Error while saving to FILENAME." where
     * FILENAME is the name of the file to save to.
     *
     * Example:
     *
     * 11111
     * The Shining
     * This would be the text of the awesome book
     * The Shining by Stephen King.
     *
     * @param filename the file to save to
     */
    public void saveToFile(String filename)
    {
        try (FileWriter out = new FileWriter(new File(filename))) {
            out.write(getNumber() + "\n");
            out.write(getTitle() + "\n");
            out.write(getText());
        } catch (FileNotFoundException e) {
            System.out.printf("Error: File not found.\n");
        }
        catch (Exception e) {
            System.out.printf("Error while loading %s.\n", filename);
        }
    }
}
