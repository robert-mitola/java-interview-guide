import java.util.*;

// class generic using generic and wildcard
class GenericThingAndNumber<S, T extends Number> {
    public S s;
    public T t;
    public GenericThingAndNumber(S s, T t){
        this.s = s;
        this.t = t;
    }
}

public class Generics {
    
    public static void main(String... args){
        
        
        // Generic wildcards
        
        List<? extends Number> numListA = new ArrayList<Number>();
        List<? extends Number> numListB = new ArrayList<Integer>();
        // List<? extends Number> numListB = new ArrayList<Object>(); <- compile time error
        
        List<? super Number> superListA = new ArrayList<Number>();
        List<? super Number> superListB = new ArrayList<Object>();
        // List<? super Number> superListB = new ArrayList<Integer>(); <- compile time error
        
        GenericThingAndNumber<String, Integer> gtn = new GenericThingAndNumber<>("Hi", 3);
        //GenericThingAndNumber<String, Object> gtn = new GenericThingAndNumber<>("Hi", new Object()); <- compile time error
        System.out.printf("%s %d%n", gtn.s, gtn.t);
    }
    
}