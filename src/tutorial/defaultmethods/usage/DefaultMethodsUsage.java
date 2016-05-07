package tutorial.defaultmethods.usage;

import tutorial.defaultmethods.*;

public class DefaultMethodsUsage {
    public static void main(String[] args) {
        Male peter = new Gentleman();
        System.out.println("peter, the gentleman, says: "+peter.greet());  //using default implementation as is

        Female mary_jane = new TexanFemale();
        System.out.println("mary_jane, the TexanFemale, responds: " + mary_jane.greet()); //Choose a super implementation in case of multiple interface implementation

        Male clint = new TexanMale();
        System.out.println("clint, the TexanMale, asks: " + clint.greet()); //Choose a super implementation in case of multiple interface implementation

        Female kate = new Duchess();
        System.out.println("kate, the duchess, corrects: " + kate.greet());  //Override super default implementation
    }
}
