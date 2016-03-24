import java.util.Scanner;

/**
   This class processes baby name records.
*/
public class RecordReader
{
   private double total;
   private double limit;
   private double percent;

   /**
      Constructs a RecordReader with a zero total.
   */
   public RecordReader(double aLimit)
   {
      total = 0;
      limit = aLimit;
   }

   /**
      Reads an input record and prints the name if the current total is less 
      than the limit.
      @param in the input stream
   */
   public void process(Scanner in)
   {
      String name = in.next();
      int count = in.nextInt();
      
      if (total < limit) { System.out.print(name + " "); }
      total = total + 1;
   }

   /**
      Checks whether there are more inputs to process
      @return true if the limit has not yet been reached
   */
   public boolean hasMore()
   {
      return total < limit;
   }
}