package exception;

/**
 * - Try statement
 * must be followed by either or both of catch and finally blocks
 * requires tedious work to declare resources outside block and to close them in finally block
 *
 * - Try with resource
 * introduced in Java 7
 * doesn't require any catch or finally block
 * resource is automatically closed at the of try block
 * Resource class must implement interface AutoClosable
 * several resource are closed in reverse order
 *
 */
class Box implements AutoCloseable {
    int id;
    public Box(int size) {
        this.id = size;
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("Box " + id +" is closed");
    }
}

class FragileBox implements AutoCloseable{
    @Override
    public void close() throws RuntimeException {
        throw new RuntimeException("can't close");
    }
}

public class TryWithResource {
    public static void main(String[] args) {
        try (Box box1 = new Box(10);
            Box box2 = new Box(20)){
            System.out.println("Look inside the box");
        }

        try(FragileBox box = new FragileBox()){
            System.out.println("Box is open");
        }
        catch (RuntimeException e){
            System.out.println("Caught: " + e.getMessage());
        }
        finally {
            System.out.println("Oh, finally!");
        }
    }
}
/* It prints:

  Look inside the box
  Box 20 is closed
  Box 10 is closed
  Box is open
  Caught: can't close
  Oh, finally!
*/
