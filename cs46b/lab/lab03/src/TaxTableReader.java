import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TaxTableReader
{

    private ArrayList<TaxData> data;

    public TaxTableReader() {
        data = new ArrayList<TaxData>();
    }

    public void read(String location)
    {

        try {
            URL url = new URL(location);
            InputStream inputStream = url.openStream();
            Scanner in = new Scanner(inputStream);
            ArrayList<String> results;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("<tr><td align=\"center\">")) {
                    results = (extractTableCells(line));

                    System.out.println();

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(CPIConverter conv, int year)
    {

    }

    private ArrayList<String> extractTableCells(String row)
    {
        ArrayList<String> result = new ArrayList<String>();
        int pos = 0;
        boolean done = false;
        while (!done)
        {
            pos = row.indexOf("<td", pos);
            if (pos == -1) done = true;
            else
            {
                pos = row.indexOf(">", pos);
                int start = pos + 1;
                pos = row.indexOf("</td>", pos);
                result.add(row.substring(start, pos));
            }
        }
        return result;
    }
}