//package p23_object_superclass;

import java.util.*;

class CloneTest implements Cloneable {
    
    public String text;
    
    public CloneTest(){}
    
    @Override 
    public CloneTest clone() throws CloneNotSupportedException {
        CloneTest cloned = (CloneTest)super.clone();
        return cloned;
    }
    
    // finalize - cleanup performed before garbage collection when no more references to an object exist
    @Override 
    protected void finalize() throws Throwable {
        System.out.println("Maybe this will print?");
    }
    
    // low level concurrency operations:
    
    // wait()
    // notify()
    // notifyAll()
    
    // check out java.util.concurrent for high level concurrency
    
}

public class p23_object_superclass {
    
    public static void main(String[] args) throws CloneNotSupportedException{
        
        // clone & shallow vs deep copy
        CloneTest a = new CloneTest();
        a.text = "here is a sentence";
        CloneTest deepCopy = a.clone();
        deepCopy.text = "new sentence";
        
        System.out.printf("a:%s%nDeep Copy:%s%n", a.text, deepCopy.text);
        
        CloneTest shallowCopy = a;
        shallowCopy.text = "both should say this";
        
        System.out.printf("a:%s%nShallow Copy:%s%n", a.text, shallowCopy.text);
        
        // equals
        // this works since equals is not overriden - if it was we could make it so deep copy does equal a
        System.out.printf("a equals deep copy? %b%na equals shallow copy? %b%n", a.equals(deepCopy), a.equals(shallowCopy));
        
        // hash code
        System.out.printf("The hash code of a is %d%n", a.hashCode());
        System.out.printf("The hash code of a's shallow copy is %d%n", shallowCopy.hashCode());
        System.out.printf("The hash code of a's deep copy is %d%n", deepCopy.hashCode());
        
        // toString (returns a hex representation of has code by default)
        System.out.printf("a to string: %s%n", a.toString());
        
        // getClass - for reflection based access to fields and methods
        Class aClass = a.getClass();
        
        
    }
    
}