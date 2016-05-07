package tutorial.defaultmethods;

public class TexanMale implements Texan, Male {

    @Override
    public String greet() {
        return Texan.super.greet(); //Choose a super implementation in case of multiple interface implementation
    }
}
