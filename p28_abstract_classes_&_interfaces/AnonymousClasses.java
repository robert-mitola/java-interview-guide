import java.util.*;

// lambda expression interface
interface IntegerMath {
    int operation(int a, int b);
}

public class AnonymousClasses {
    
    // local interface
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }
    
    public void sayHello(){
        
        // local class
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone){
                name = someone;
                System.out.println("Hello " + name);
            }
        }
        
        HelloWorld englishGreeting = new EnglishGreeting();
        
        // anonymous class
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet(){
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone){
                name = someone;
                System.out.println("salut " + name);
            }
        }; // <------------ Note the semicolon
        
        englishGreeting.greet();
        frenchGreeting.greet();
        
    }
    
    public static void main(String... args){
        AnonymousClasses myApp = new AnonymousClasses();
        myApp.sayHello();
        
        // lambda expressions
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        
        System.out.printf("4+3=%d%n", addition.operation(4, 3));
        System.out.printf("4-3=%d%n", subtraction.operation(4, 3));
        
    }
    
}