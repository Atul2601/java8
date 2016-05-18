package tutorial.streams;

class Person {

    static Person allocateSSN(long ssn){
        return new Person(ssn);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    private Person(long ssn) {
        this.ssn = ssn;
        this.name= "a"+ssn;
    }

    private final long ssn;
    private final String name;
}
