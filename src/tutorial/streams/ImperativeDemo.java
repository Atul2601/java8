package tutorial.streams;

public class ImperativeDemo {
    public static void main(String[] args) {
        long start = System.nanoTime();

        Person person;
        for (Long i=1L;i<=100000; i++){
            person = Person.allocateSSN(i);
            person.toString();
        }
        System.out.println(System.nanoTime()-start);
    }
}

//1,00,00,938
//6,37,52,478

//4,35,36,706
//11,12,83,018