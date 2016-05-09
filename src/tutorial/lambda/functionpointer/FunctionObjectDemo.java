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

        PhoneNumber johns = new PhoneNumber("012-1111");
        PhoneNumber jacks = new PhoneNumber("011-1112");
        PhoneNumber kates = new PhoneNumber("012-1111");
        PhoneNumber kathys = new PhoneNumber("010-3333");
        PhoneNumber madelines = new PhoneNumber("030-1111");
        PhoneNumber gussies = new PhoneNumber("030-1111");
        PhoneNumber stiffys = new PhoneNumber("030-1222");
        PhoneNumber berties = new PhoneNumber("010-9999");
        return Arrays.asList(johns,jacks,kates, kathys, madelines, gussies, stiffys, berties);
    }
}
