package tutorial.defaultmethods;

public class Duchess implements Female{
    @Override
    public String greet() {
        return "How do you do?";  //Override super default implementation
    }
}
