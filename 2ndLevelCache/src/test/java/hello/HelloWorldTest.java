package hello;

import org.hsqldb.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {

    @Before
    public void startDB() {
        Server.main(new String[] {});
    }

    @After
    public void stopDB() {
        //TODO shutdown HSQLDB method
    }

    @Test
    public void runHibernateTest() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.runHibernate();
    }
}
