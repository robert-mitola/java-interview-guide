import java.util.*;


// abstract class - designed to be extended and cannot be instantiated
abstract class Person {

    // ONLY conrete field
    protected String name;
    protected int id;

    // concrete methods
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    // abstract method
    public abstract void setId(int id);
    public abstract int getId();
    
}

// interface - promote polymorphism by describing a form that an object can take
interface Taxable {
    
    // traditionally contain constant fields
    public final int RATE = 3;
    
    // traditionally contain empty methods
    public int getRate();
    
    // Java 8 introduced static methods
    public static void sayHello(){
        System.out.println("Time to get taxed!");
    }
    
    // Java 8 introduced default/defender methods
    default public void newFunction(){
        System.out.println("Older classes may not implement me, so I'll print this if so.");
    }
    
}

// extends should go before implements when using both
class Employee extends Person implements Taxable {
    
    public Employee(){}
    
    // must implement all non-default interface methods
    public int getRate(){
        return this.RATE * 2;
    }
    
    // must implement all abstract classes to be instantiated
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
}

// anonymous class - 

public class Abstract {
 
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.setName("Rob");
        employee.setId(1);
        System.out.printf("%d:%s:$%d%n", employee.getId(), employee.getName(), employee.getRate());
        Taxable.sayHello();
        employee.newFunction();
    }
    
}