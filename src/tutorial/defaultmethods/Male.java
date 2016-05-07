package tutorial.defaultmethods;

public interface Male {
    default String greet(){
        return "Hi";
    }
}
