import java.util.*;
import java.io.*;

// all exceptions descend from Throwable

// common unchecked exceptions:

// RuntimeException
// NullPointerException
// IllegalArgumentException
// ClassCastException

// common checked exceptions:

// IOException
// FileNotFoundException
// InterruptedException

// common errors

// OutOfMemoryError
// StackOverflowError

public class Exceptions {
    
    private static void throwsError() throws IOException {
        throw new IOException("thrown from method");
    }
    
    public static void main(String... args) {
    
        // checked exceptions
        // try/catch/finally
        try{
            throw new IOException("thrown from try");
        }catch(IOException e){
            System.err.println(e);
        }finally{
            System.out.println("FINALLY!!!!!");
        }
        
        try{
            throwsError();
        }catch(IOException e){
            System.err.println(e + " ...and caught in catch");
        }
        // try-with-resources (Java 7) - for resources that implement AutoCloseable
        try(BufferedReader br = new BufferedReader(new FileReader("does/not/exist"))){
            System.out.println(br.readLine());
        }catch(IOException e){
            System.err.println(e);
        }
        // no need for finally - try-with-resources will automatically close buffered reader after try block
    
        // unchecked exception
        int[] arr = new int[3];
        int ArrayIndexOutOfBoundsException = arr[3];
        
        // program flow will terminate after unchecked exception
        
        System.out.println("got here");
    }
    
    
    
}