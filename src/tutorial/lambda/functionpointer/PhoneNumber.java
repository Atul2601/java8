package tutorial.lambda.functionpointer;

class PhoneNumber {
    private final int areaCode;
    private final int number;

    public PhoneNumber(String phoneNumberWithAreaCode) {
        String[] parts = phoneNumberWithAreaCode.split("-");
        this.areaCode = Integer.valueOf(parts[0]);
        this.number= Integer.valueOf(parts[1]);

    }

    public int getNumber() {
        return number;
    }

    public int getAreaCode() {
        return areaCode;
    }

    @Override
    public String toString() {
        return areaCode +"-" +number;
    }
}
