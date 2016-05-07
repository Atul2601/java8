package tutorial.defaultmethods.usage;

import tutorial.defaultmethods.*;

public class DefaultMethodsUsage {
    public static void main(String[] args) {
        Male peter = new Gentleman();
        System.out.println("peter, the gentleman, says: "+peter.greet());

        Female mary_jane = new TexanFemale();
        System.out.println("mary_jane, the TexanFemale, says: " + mary_jane.greet());

        Male clint = new TexanMale();
        System.out.println("clint, the TexanMale, says: " + clint.greet());

        Female kate = new Duchess();
        System.out.println("kate, the duchess, corrects: " + kate.greet());
    }

}
