import java.util.*;
import java.util.concurrent.*; // for concurrent data structures
import java.util.concurrent.atomic.*; // for atomic variables

// synchronization
// for static methods the lock is the class
// for instance methods the lock is the object
class Counter {
    
    // volatile keyword
    public volatile Boolean finished = false;
    
    public static int c;
    public int d;
    
    public Counter(){
        this.c = 0;
        this.d = 0;
    }
    
    // synchronized keyword
    public static synchronized void incrementC(){
        c++;
    }
    
    public synchronized void incrementD(){
        d++;
    }
    
}

// atomic variables instead of locks for synchronization
class SafeCounterWithoutLock {
    
    // can all be atomically updated - no need to declare volatile or only use with synchronized method calls
    public static final AtomicInteger intCounter = new AtomicInteger(0);
    public static final AtomicLong longCounter = new AtomicLong(0);
    public static final AtomicBoolean bool = new AtomicBoolean(false);
    public static final AtomicReference object = new AtomicReference(new Object());
    
}

// option 1 - subclass the Thread class and call its start
class ThreadObjA extends Thread {
    
    int a;
    Counter counter;
    
    public ThreadObjA(int a, Counter counter){
        this.a = a;
        this.counter = counter;
    }
    
    // JVM calls run() after start
    public void run(){
        while(this.a != 0){
            Counter.incrementC();
            this.counter.incrementD();
            System.out.printf("a:%d%n", this.a--);
        }
        System.out.println("A done.");
        this.counter.finished = true;
        
        // need to use set method calls
        SafeCounterWithoutLock.intCounter.set(SafeCounterWithoutLock.intCounter.get()+1);
        SafeCounterWithoutLock.longCounter.set(SafeCounterWithoutLock.longCounter.get()+1);
        SafeCounterWithoutLock.bool.set(true);        
        
    }
    
    
}

// option 2 - implementing runnable and passing it to a thread, then starting the thread
class ThreadObjB implements Runnable {
    
    int b;
    Counter counter;
    
    public ThreadObjB(int b, Counter counter){
        this.b = b;
        this.counter = counter;
    }
    
    // JVM calls run() after start
    public void run(){
        while(this.b != 0){
            Counter.incrementC();
            this.counter.incrementD();
            System.out.printf("b:%d%n", this.b--);
        }
        System.out.println("B done.");
        this.counter.finished = true;
        
        // need to use set method calls
        SafeCounterWithoutLock.intCounter.set(SafeCounterWithoutLock.intCounter.get()+1);
        SafeCounterWithoutLock.longCounter.set(SafeCounterWithoutLock.longCounter.get()+1);
        SafeCounterWithoutLock.bool.set(true);   
        
    }
    
}

public class Concurrency {
    
    public static void main(String[] args) throws InterruptedException {
        
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        
        ThreadObjA thread = new ThreadObjA(5, counterA);
        ThreadObjB runnable = new ThreadObjB(5, counterB);
        
        thread.start();
        new Thread(runnable).start();

        while(!counterA.finished || !counterB.finished){
            // volatile booleans guarantees write happens before read
        }
        
        System.out.printf("Counter A: %d%nCounter B: %d%nStatic Val: %d%n", counterA.d, counterB.d, Counter.c);
        
        // java.util.concurrent data structures
        
        List<Integer> ints = new CopyOnWriteArrayList<>();
        ints.add(3);
        
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("test", 1);
        
        BlockingQueue q = new LinkedBlockingQueue<Integer>();
        q.put(3); // should use this to block
        q.take(); // should use this to block
        
        // need to use get method calls
        System.out.printf("Atomics: %d %d %b%n", SafeCounterWithoutLock.intCounter.get(), SafeCounterWithoutLock.longCounter.get(), SafeCounterWithoutLock.bool.get());
        
    }
    
}