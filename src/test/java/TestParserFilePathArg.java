import Adbistju.system.ParserFilePathArg;
import Adbistju.system.exception.ArgumentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class TestParserFilePathArg {
    @Test
    public void TestPathArg(){
        ParserFilePathArg pathArg =  new ParserFilePathArg();
        Assert.assertEquals(pathArg.addParams(new String[] {"-f", "C:\\directoryName"}), "C:\\directoryName" );
    }

    @Test
    public void TestPathArg1(){
        ParserFilePathArg pathArg =  new ParserFilePathArg();
        try {
            Assert.assertEquals(
                    pathArg.addParams(new String[] {}),
                    new ArgumentException("few arguments were provided")
            );
        }catch (ArgumentException a){
            System.out.println("test pass");
        }
    }
}
