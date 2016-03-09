import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)
        {
            tempList = new ArrayList<Integer>();
        }
        else
        {
            tempList = new ArrayList<Integer>();
            tempList.add(n);
            tempList.addAll(0, makeList(n-1));
        }
        return tempList;
    }
    
    public static ArrayList<Integer> reverseList(ArrayList<Integer> list)
    {
        ArrayList<Integer> tempList = null;
        tempList = new ArrayList<Integer>();
        tempList.add(list.get(list.size()-1));
        return tempList;
    }
}