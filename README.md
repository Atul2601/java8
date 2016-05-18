# java8
Adding a structured tutorial to get my team started on java 8.


java 8

Optional- Functional languages like Haskell or Scala structurally resolve NullPointerException problem by wrapping the nullable values in an Option/Maybe monad.
 imperative languages like Groovy introduced a null-safe dereferencing operator (?. operator) to safely navigate values that could be potentially null.

Functional Interface:
Single abstract method ex. Runnable, Comparator
Compile time error if you annotate an interface with more than one method using the annotation @FunctionalInterface



Default methods:
For backward compatibility

interface Female {
    default void sayHello() {
        System.out.println("Hiiiiiieeee”);
    }
}

interface Texan {
    default void sayHello() {
        System.out.println(“Howdy”);
    }
}
 
class MaryJane implements Texan, Female {
		//override the sayHello to resolve ambiguity,
		//In absence of override, compiler is unhappy
    void sayHello() {
        Male.super.sayHello();
    }

}



Abstract class can hold state of object. It can have constructors and member variables.
Whereas interfaces with Java 8 default methods cannot hold state. It cannot have constructors and member variables.
You should still use Abstract class whenever you think your class can have state or you need to do something in constructor.
Default method should be used for backward compatibility. Whenever you want to add additional functionality in an existing legacy interface you can use default methods without breaking any existing implementor classes.
Also abstract classes cannot be root classes in Lambda expression.

……..
Function Pointers
Some languages support function pointers, delegates, lambda expressions, or similar facilities that allow programs to store and transmit the ability to invoke a particular function. Such facilities are typically used to allow the caller of a function to specialize its behavior by passing in a second function. For example, the qsortfunction in C's standard library takes a pointer to a comparator function, which qsort uses to compare the elements to be sorted. The comparator function takes two parameters, each of which is a pointer to an element.

Different sort orders can be obtained by passing in different comparator functions. This is an example of the Strategy.

Java5 does not provide function pointers, but object references can be used to achieve a similar effect. Invoking a method on an object typically performs some operation on that object. However, it is possible to define an object whose methods perform operations on other objects, passed explicitly to the methods. An instance of a class that exports exactly one such method is effectively a pointer to that method. Such instances are known as function objects. For example, consider the following class:
class StringLengthComparator {     public int compare(String s1, String s2) {         return s1.length() - s2.length();     } }


Arrays.sort(stringArray, new Comparator<String>() {
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});

A reference to a StringLengthComparator object serves as a "function pointer" to this comparator, allowing it to be invoked on arbitrary pairs of strings.
In other words, a StringLengthComparator instance is a concrete strategy for string comparison.


A closure is a function or reference to a function together with a referencing environment(a table storing a reference to each of the non-local variables of that function).
Closest thing that Java can provide to Closure is Lambda expressions. There is significant difference between a Closure and Lambda expression, but at least Lambda expression provides a good alternative to Closure.

In languages that support first class functions, the type of the lambda expression would be a function; but in Java, the lambda expressions are represented as objects, and so they must be bound to a particular object type known as a functional interface.





Lambda expressions in Java is usual written using syntax (argument) -> (body). For example:
(arg1, arg2...) -> { body }
 
(type1 arg1, type2 arg2...) -> { body }

(int a, int b) -> {  return a + b; }
 
() -> System.out.println("Hello World");
 
(String s) -> { System.out.println(s); }


Structure of Lambda Expressions
* A lambda expression can have zero or more parameters.
* The type of the parameters can be explicitly declared or it can be omitted if it can inferred from the context. (int a) can be same as (a)
* Parameters are enclosed in parentheses and separated by commas. e.g. (a, b) or (int a, int b) or (String a, int b, float c)
* Empty parentheses are used to represent an empty set of parameters. e.g. () -> System.out.println("Hello World");
* When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses. e.g. a -> return a*a
* The body of the lambda expressions can contain zero or more statements.
* If body of lambda expression has single statement curly brackets are not mandatory and the return type of the anonymous function is the same as that of the body expression.
* More than one statement in body must be enclosed in a code block.
* The return type of the lambda is the same as the type of the return value of the code block, or void if nothing is returned.

//Old way:
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello from thread");
    }
}).start();
 
//New way:
new Thread(
    () -> System.out.println("Hello from thread")
).start();

Lambdas make it easy to express behavior as data, which in turn makes it possible to develop more-expressive and more-powerful libraries.

Streams exploit that most powerful of computing principles: composition. By composing complex operations out of simple building blocks (filtering, mapping, sorting, aggregation), streams queries are more likely to remain straightforward to write and read as the problem gets complicated

Without Streams and lambdas, legacy code needs you to mentally buffer a lot of context before figuring out what the code actually does.

txns.stream()
    .filter(t -> t.getBuyer().getAge() >= 65)
    .map(Txn::getSeller)
    .distinct()
    .sorted(comparing(Seller::getName))
    .map(Seller::getName)
    .forEach(System.out::println);

The code in Listing 3 is far easier to read, because the user is neither distracted with "garbage" variables — like sellers and sorted— and doesn't have to keep track of a lot of context while reading the code; the code reads almost exactly like the problem statement. Code that's more readable is also less error prone, because maintainers are more likely to be able to correctly discern at first glance what the code does.

The design approach taken by libraries like Streams leads to a practical separation of concerns. The client is in charge of specifying the "what" of a computation, but the library has control over the "how." This separation tends to parallel the distribution of expertise; the client writer generally has better understanding of the problem domain, whereas the library writer generally has more expertise in the algorithmic properties of the execution. The key enabler for writing libraries that allow this sort of separation of concerns is the ability to pass behavior as easily as passing data, which in turn enables APIs where callers can describe the structure of a complex calculation, and then get out of the way while the library chooses the execution strategy.

All stream computations share a common structure: They have a stream source, zero or more intermediate operations, and a single terminal operation.

Intermediate operations — such as filter() (selecting elements matching a criterion), map() (transforming elements according to a function), distinct() (removing duplicates), limit() (truncating a stream at a specific size), and sorted()— transform a stream into another stream.

Intermediate operations are always lazy: Invoking an intermediate operation merely sets up the next stage in the stream pipeline but doesn't initiate any work. The processing of the data set begins when a terminal operation is executed. Terminal operations produce a result or a side effect.

A collection is a data structure; its main concern is the organization of data in memory, and a collection persists over a period of time. A collection might often be used as the source or target for a stream pipeline, but a stream's focus is on computation, not data.
