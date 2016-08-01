package model.comparators;

import java.util.Comparator;

/**
 * Created by MSI on 31.07.2016.
 */
public class ComparatorFactory {

    public static Comparator buildComparator(String comparatorName)
    {
        if(("price").equals(comparatorName)) return new SortByPrice();
        if(("description").equals(comparatorName)) return  new SortByName();

        else return null;
    }

}
