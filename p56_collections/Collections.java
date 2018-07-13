import java.util.*;

public class Collections {
    
    
    
    
    public static void main(String[] args){
        
    // COLLECTION
        
        // LIST
        
            // ARRAY LIST
            
            ArrayList<Integer> arrayList = new ArrayList<>(10); // default initializable
            
                // Empty? O(1)
                arrayList.isEmpty();
                
                // Size O(n)
                arrayList.size();
                
                // Insertion O(1)
                arrayList.add(0);
                arrayList.add(1);
                arrayList.add(2);
                arrayList.add(3);
                
                // Deletion
                arrayList.remove(2); // O(1)
                //arrayList.clear(); // O(n)
                
                // Setting
                arrayList.set(2, 100); // O(n)
                
                // Search 
                arrayList.get(1); // O(1)
                arrayList.contains(3); // O(n)
                arrayList.indexOf(3); // O(n)
                
                // Shallow Copy O(n)
                arrayList.clone();
          
                // To Array O(n)
                arrayList.toArray();
            
            // LINKED LIST (Also implements DEQUE)
            
            LinkedList<Integer> linkedList = new LinkedList<>(); // non-default initializable    
            
                // Empty? O(1)
                linkedList.isEmpty();
                
                // Size O(n)
                linkedList.size();
                
                // Insertion O(1);
                linkedList.add(0); // end
                linkedList.add(1); // end
                linkedList.addLast(2); // end
                linkedList.addLast(3); // end
                linkedList.addFirst(4); // start
                linkedList.addFirst(5); // start
                
                // Deletion O(1)
                linkedList.removeLast(); // end, throws if empty
                linkedList.removeFirst(); // start, throws if empty
                
                // Setting O(n)
                linkedList.set(1, 100);
                
                // Search O(1)
                linkedList.getFirst(); // does not remove, null if empty
                linkedList.getLast(); // does not remove, null if empty
                linkedList.pollFirst(); // removes, null if empty 
                linkedList.pollLast(); // removes, null if empty
                
                // Shallow Copy O(n)
                linkedList.clone();
                
                // To Array O(n)
                linkedList.toArray();
                
        // MAP
        
            // HASHMAP
            
            Map<String, Integer> map = new HashMap<String, Integer>(100, 0.75f); // default capacity, load factor
            
                // Size O(n)
                map.size();
                
                // Put O(1)
                map.put("One", 1);
                map.put("Two", 1);
                map.put("Three", 1);
                
                // Search O(1)
                map.get("Four"); // returns null if not found
                map.getOrDefault("Four", 4); // return default if not found
                map.values(); // O(n)
                
                // Update O(1)
                map.replace("One", 2); // updates if key exists
                map.replace("One", 2, 1); // updates if key exists and value matches second param
                
                // Delete O(1)
                map.remove("Two");
                map.remove("Three", 3); // removes if value matches
            
        // DEQUE
        
            // ARRAY DEQUE
            Deque<Integer> arrayDeque = new ArrayDeque<Integer>(10);
            
            arrayDeque.add(1);
            arrayDeque.add(2);
            arrayDeque.add(3);
            
            // Works like linked list
            // does not implement the list interface!
            // array deque is better for adding to start and end, iterating, ect...
            // linked list is better at deletion and supports null values
            
        // QUEUE
            
            // PRIORITY QUEUE
        
            Queue<Integer> priorityQueue = new PriorityQueue<Integer>(10);
            
            priorityQueue.size();
            
            priorityQueue.add(3);
            priorityQueue.add(4);
            priorityQueue.add(1);
            priorityQueue.add(7);
            priorityQueue.add(7);
            priorityQueue.add(9);
            priorityQueue.add(0);
            
            priorityQueue.peek();
            priorityQueue.poll();
            
        
        // also does not implement the list interface
        
        // SET
        
        // ITERATOR
        
        Iterator<Integer> listIt = arrayList.listIterator();
        System.out.println("array list");
        while(listIt.hasNext()){
            System.out.printf("%d ", listIt.next());
            listIt.remove();
        }
        System.out.println("");
        
        Iterator<Integer> listIt2 = linkedList.listIterator();
        System.out.println("linked list");
        while(listIt2.hasNext()){
            System.out.printf("%d ", listIt2.next());
            listIt2.remove();
        }
        System.out.println("");
        
        Iterator<Integer> dequeIt = arrayDeque.iterator();
        System.out.println("dequeue");
        while(dequeIt.hasNext()){
            System.out.printf("%d ", dequeIt.next());
        }
        System.out.println("");
        
        Iterator<Integer> dequeItDesc = arrayDeque.descendingIterator();
        System.out.println("dequeue reversed");
        while(dequeItDesc.hasNext()){
            System.out.printf("%d ", dequeItDesc.next());
            dequeItDesc.remove();
        }
        System.out.println("");
        
    }
    
}