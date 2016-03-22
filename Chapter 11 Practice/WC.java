import java.util.Scanner;
import java.io.*;


public class WC
{
    public static void main(String[] args)
    {
        try
        {
            //Scanner temp = new Scanner(System.in);
            //System.out.print("File Name: ");
            //String fileName = temp.next();
            File inputFile = new File("biblekjv.txt");
            //File inputFile = new File(fileName);
            Scanner in = new Scanner(inputFile);
            
            in.useDelimiter("");
            int counter = 0;
            while (in.hasNext())
            {
                counter += 1;
            }
            System.out.println("Number of Characters: " + counter);
            
            in.useDelimiter(" ");
            counter = 0;
            while (in.hasNext())
            {
                counter += 1;
            }
            System.out.println("Number of Words: " + counter);
            
            in.useDelimiter("\n");
            counter = 0;
            while (in.hasNext())
            {
                counter += 1;
            }
            System.out.println("Number of Lines: " + counter);
            
            in.close();
        }
        catch (IOException ioe)
        {
            
        }
    }
}