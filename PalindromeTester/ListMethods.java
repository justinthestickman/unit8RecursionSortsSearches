import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        //ArrayList<Integer> tempList = null;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if (n <= 0)
        {
            //tempList = new ArrayList<Integer>();
            return tempList;
        }
        else
        {
            //tempList = new ArrayList<Integer>();
            tempList.add(n);
            tempList.addAll(0, makeList(n-1));
        }
        return tempList;
    }
    
    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = deepClone(tList);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if (list.isEmpty())
        {
            return tempList;
        }
        else
        {
            tempList.add(list.get(0));
            list.remove(0);
            tempList.addAll(0, reverseList(list));
        }
        return tempList;
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