package tutorial.functionobjects;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionObjectExample {


    public static void main(String[] args) {
        //comp is a function object
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        };

        String[] values = new String[]{"ab","c","defg","hij"};
        sort(values, comp);
        System.out.println("sorted to..."+Arrays.toString(values));
    }

    static void sort(String[] values, Comparator<String> comp){
        for (int i=0; i<values.length; i++)
            for (int j=i; j>0 && comp.compare(values[j-1], values[j])>0; j--){
                String temp = values[j];
                values[j] = values[j-1];
                values[j-1] = temp;
            }
    }
}
