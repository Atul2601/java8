package tutorial.lambda.functionpointer;

import java.util.*;

public class FunctionObjectDemo {
    public static void main(String[] args) {
        List<PhoneNumber> contactNumbers = createDirectory();

        Collections.sort(contactNumbers, new PhoneComparator());
        System.out.println(contactNumbers.toString());


        Collections.sort(contactNumbers, new Comparator<PhoneNumber>(){
            @Override
            public int compare(PhoneNumber firstPhoneNumber, PhoneNumber secondPhoneNumber) {
                if (firstPhoneNumber.getAreaCode() == secondPhoneNumber.getAreaCode()) {
                    return secondPhoneNumber.getNumber() - firstPhoneNumber.getNumber();
                }
                return firstPhoneNumber.getAreaCode() - secondPhoneNumber.getAreaCode();
            }
        });
        System.out.println(contactNumbers.toString());


    }

    private static List<PhoneNumber> createDirectory() {

        PhoneNumber john = new PhoneNumber("012-1111");
        PhoneNumber jack = new PhoneNumber("011-1112");
        PhoneNumber kate = new PhoneNumber("012-1111");
        PhoneNumber kathy = new PhoneNumber("010-3333");
        PhoneNumber madeline = new PhoneNumber("030-1111");
        PhoneNumber gussie = new PhoneNumber("030-1111");
        PhoneNumber stiffy = new PhoneNumber("030-1222");
        PhoneNumber bertie = new PhoneNumber("010-9999");
        return Arrays.asList(john,jack,kate, kathy, madeline, gussie, stiffy, bertie);
    }
}
