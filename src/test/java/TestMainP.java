import Adbistju.system.Main;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TestMainP {
    private final String pathFileTest = "test.xml";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void ExactNoSearchInput() {
        String[] args = {"-f", pathFileTest};
        Main.main(args);
        String expected = "/file-776194140.xml\r\n" +
                "/dir-880176375\r\n" +
                "/dir-880176375/file-1073842118.java\r\n" +
                "/dir-880176375/dir-2145307015\r\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n" +
                "/dir-880176375/file-09061999.java\r\n";
        Assert.assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void ExactSearchInput() {
        String[] args = {"-f", pathFileTest, "-s", "`file-1498940214.xhtml`"};
        Main.main(args);
        String expected = "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n";
        Assert.assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void SimpleSearchInput() {
        String[] args = {"-f", pathFileTest, "-s", "*.java"};
        Main.main(args);
        String expected = "/dir-880176375/file-1073842118.java\r\n" +
                "/dir-880176375/file-09061999.java\r\n";
        Assert.assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void ExtendedSearchInput() {
        String[] args = {"-f", pathFileTest, "-s", "`.*?[a-z]{4}-\\d+\\.[a-z]+`"};
        Main.main(args);
        String expected = "/file-776194140.xml\r\n" +
                "/dir-880176375/file-1073842118.java\r\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n" +
                "/dir-880176375/file-09061999.java\r\n";
        Assert.assertEquals(expected, outputStreamCaptor.toString());
    }
}
