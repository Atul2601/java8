package tutorial.lambda.functionpointer;

import java.util.Comparator;

class PhoneComparator implements Comparator<PhoneNumber> {

    @Override
    public int compare(PhoneNumber firstPhoneNumber, PhoneNumber secondPhoneNumber) {
        if (firstPhoneNumber.getAreaCode() == secondPhoneNumber.getAreaCode()) {
            return secondPhoneNumber.getNumber() - firstPhoneNumber.getNumber();
        }
        return firstPhoneNumber.getAreaCode() - secondPhoneNumber.getAreaCode();
    }
}