package pckg_fst;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arrInt = AUX_CLS.getIntArray(10);
        System.out.println(Arrays.toString(arrInt));
        String [] someStrings = {"String1", "Novi", "Treći", "Tako dalje", "Finalni"};
        String [] anotherStr;
        String [] newString = new String[5];
        anotherStr = newString;
        printStringArrayElements(someStrings);
        System.out.println("---------------------------------------------");
        printStringArrayElements(anotherStr);
        anotherStr = someStrings;
        System.out.println(anotherStr);
    }

    public static void printStringArrayElements(String[] arr){
        for(String el: arr){
            System.out.println(el);
        }
    }
}
