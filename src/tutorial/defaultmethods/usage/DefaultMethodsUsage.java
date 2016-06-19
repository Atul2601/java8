package tutorial.defaultmethods.usage;

import tutorial.defaultmethods.*;

public class DefaultMethodsUsage {
    public static void main(String[] args) {
        Male peter = new Gentleman();
        System.out.println("Peter, the gentleman, says: "+peter.greet());  //using default implementation as is

        Female mary_jane = new TexanFemale();
        System.out.println("Mary Jane, the TexanFemale, responds: " + mary_jane.greet()); //Choose a super implementation in case of multiple interface implementation

        Male clint = new TexanMale();
        System.out.println("Clint, the TexanMale, asks: " + clint.greet()); //Choose a super implementation in case of multiple interface implementation

        Female kate = new Duchess();
        System.out.println("Kate, the duchess, corrects: " + kate.greet());  //Override super default implementation
    }


//    output
//    Peter, the gentleman, says: Hi
//    Mary Jane, the TexanFemale, responds: Hiiieeee
//    Clint, the TexanMale, asks: Howdy
//    Kate, the duchess, corrects: How do you do?
}
