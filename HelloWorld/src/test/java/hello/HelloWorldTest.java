package hello;

import org.hsqldb.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class HelloWorldTest {

    @Before
    public void startDB() {
        Server.main(new String[]{});
        
    }
    @After
    public void stopDB(){
        
    }
    @Test
    public void main() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.main(new String[]{});
        
//        throw new RuntimeException("Test not implemented");
    }
}
