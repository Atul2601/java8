package tutorial.defaultmethods;

public interface Texan {
    default String greet(){
        return "Howdy";
    }
}

