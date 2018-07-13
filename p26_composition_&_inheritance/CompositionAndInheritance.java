import java.util.*;

// composition - prevent code duplication by delegating functionality to other objects
// use for HAS-A relationship (a party HAS A guest list)
class Party {
    
    private List<String> guests;
    
    public Party(){
        this.guests = new ArrayList<>();
    }
    
    public void addGuest(String guest){
        this.guests.add(guest);
    }
    
}

// inheritance - prevent code duplication by inheriting functionality from parent objects
// use for IS-A relationship (a student IS A person)
class Party2<T> extends ArrayList<T> {
    
    public Party2(){}
    
}

public class CompositionAndInheritance {
    
    
    
    public static void main(String[] args){
        
        // composition
        Party party = new Party();
        party.addGuest("Rob");

        // inheritance
        Party2<String> party2 = new Party2<>();
        party2.add("Rob");
        for(String guest : party2){
            System.out.println(guest);
        }
     
    }
    
}