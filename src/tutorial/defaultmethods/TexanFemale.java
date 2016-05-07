package tutorial.defaultmethods;

public class TexanFemale implements Female, Texan {
    @Override
    public String greet() {
        return Female.super.greet(); //Choose a super implementation in case of multiple interface implementation
    }
}
