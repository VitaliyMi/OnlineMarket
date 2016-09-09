package application;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSI on 06.09.2016.
 */
public class Test {

    public static void main(String[] args) {
       try{
           System.out.println("It is okay");
           throwMethod(1);
           System.out.println("Oh no no");
       }
       catch (RuntimeException e)
       {
           System.out.println("Exception caught");
       }
    }

    private static void throwMethod(int i)
    {
        if(i==1) throw new RuntimeException();
        System.out.println("In throwMethod");
    }

}
