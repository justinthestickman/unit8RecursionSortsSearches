import java.util.Scanner;
import java.io.*;

public class WC
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner console = new Scanner(System.in);
            System.out.print("File Name: ");
            String fileName = console.next();
            File file = new File(fileName);
            
            Scanner in = new Scanner(file);
            int counter = 0;
            in.useDelimiter("");
            while (in.hasNext())
            {
                String character = in.next();
                counter += 1;
            }
            System.out.println("Number of Characters: " + counter);
            in.close();
            
            in = new Scanner(file);
            counter = 0;
            while (in.hasNext())
            {
                String word = in.next();
                counter += 1;
            }
            System.out.println("Number of Words: " + counter);
            in.close();
            
            in = new Scanner(file);
            counter = 0;
            in.useDelimiter("\n");
            while (in.hasNext())
            {
                String line = in.next();
                counter += 1;
            }
            System.out.println("Number of Lines: " + counter);
            in.close();
        }
        catch (IOException ioe)
        {
            System.out.println("File does not exist");
        }
    }
}