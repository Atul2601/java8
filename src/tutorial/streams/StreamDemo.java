package tutorial.streams;

import java.util.stream.LongStream;

public class StreamDemo {
    public static void main(String[] args) {
        primeNumberStream();

//        parallelPrimeNumberStream();


    }

    private static void parallelPrimeNumberStream() {
        long start;
        start = System.currentTimeMillis();
        LongStream.range(1, 1000000000000000000L)
                .parallel()
                .filter(n-> n%2!=0)
                .filter(n-> LongStream.range(3, n/2).noneMatch(i-> n%i==0))
                .filter(n->n%10L==3)
                .toString();

        System.out.println("cores: "+Runtime.getRuntime().availableProcessors());
        System.out.println(System.currentTimeMillis()-start+"*****");
    }

    private static void primeNumberStream() {
        long start = System.currentTimeMillis();
        LongStream.range(1, 1000000000000000000L)
                .filter(n-> n%2!=0)
                .filter(n-> LongStream.range(3, n/2).noneMatch(i-> n%i==0))
                .filter(n->n%10L==3)
                .toString();
        System.out.println("cores: "+Runtime.getRuntime().availableProcessors());
        System.out.println(System.currentTimeMillis()-start+"*****");
    }
}
