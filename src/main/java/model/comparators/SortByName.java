package model.comparators;

import model.Dish;

import java.util.Comparator;

/**
 * Created by MSI on 30.05.2016.
 */
public class SortByName implements Comparator<Dish>{

    @Override
    public int compare(Dish o1, Dish o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
