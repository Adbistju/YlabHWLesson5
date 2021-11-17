package xmlparser;

import Adbistju.system.Main;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class TestMain {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//    @Test
//    public void NoSearchInput() {
//        String[] args = {"-f", "test.xml"};
//        Main.main(args);
//        String expected = "/file-776194140.xml\r\n" +
//                "/dir-880176375/file-1073842118.java\r\n" +
//                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n" +
//                "/dir-880176375/file-123.java\r\n";
//        Assert.assertEquals(expected, outputStreamCaptor.toString());
//    }
    @Test
    public void NoSearchInput(){

    }
//
//    @Test
//    void ExactSearchInput() {
//        String[] args = {"-f", "test.xml", "-s", "file-1498940214.xhtml"};
//        Main.main(args);
//        String expected = "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n";
//        Assert.assertEquals(expected, outputStreamCaptor.toString());
//    }
//
//    @Test
//    void SimpleSearchInput() {
//        String[] args = {"-f", "test.xml", "-s", "‘*.java’"};
//        Main.main(args);
//        String expected = "/dir-880176375/file-1073842118.java\r\n" +
//                "/dir-880176375/file-123.java\r\n";
//        Assert.assertEquals(expected, outputStreamCaptor.toString());
//    }
//
//    @Test
//    void ExtendedSearchInput() {
//        String[] args = {"-f", "test.xml", "-S", "‘.*?[a-z]{4}-\\d+.[a-z]+’"};
//        Main.main(args);
//        String expected = "/file-776194140.xml\r\n" +
//                "/dir-880176375/file-1073842118.java\r\n" +
//                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\r\n" +
//                "/dir-880176375/file-123.java\r\n";
//        Assert.assertEquals(expected, outputStreamCaptor.toString());
//    }
}