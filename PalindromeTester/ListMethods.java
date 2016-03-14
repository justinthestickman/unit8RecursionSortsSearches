import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        //ArrayList<Integer> tempList = null;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if (n <= 0)
        {
            tempList = new ArrayList<Integer>();
        }
        else
        {
            tempList = makeList(n - 1);
            tempList.add(n);
        }
        return tempList;
    }
    
    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList);
        if (list.isEmpty())
        {
            return list;
        }
        else
        {
            Integer tempInt = list.remove(0);
            list = ListMethods.reverseList(list);
            list.add(tempInt);
        }
        return list;
    }
    
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
}