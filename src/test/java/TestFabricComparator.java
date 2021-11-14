import Adbistju.system.comparator.ComparatorByNoParams;
import Adbistju.system.comparator.ComparatorByRegular;
import Adbistju.system.comparator.ConverterMaskToRegular;
import Adbistju.system.comparator.FabricComparator;
import Adbistju.system.exception.ArgumentException;
import org.junit.Assert;
import org.junit.Test;

public class TestFabricComparator {

        @Test
        public void TestFabricComparator(){
            try {
                Assert.assertEquals(
                        new FabricComparator().FabricComparator(new String[] {}).getClass(),
                        new ArgumentException("no find argument")
                );
            }catch (ArgumentException a){
                System.out.println("test pass");
            }

            Assert.assertEquals(
                    new FabricComparator().FabricComparator(
                            new String[] {"-f", "D:\\!\\test.xml"}).getClass(),
                    new ComparatorByNoParams().getClass()
            );

            Assert.assertEquals(
                    new FabricComparator().FabricComparator(
                            new String[] {"-s", "*.java"}).getClass(),
                    new ComparatorByRegular(ConverterMaskToRegular.addParam("*.java")).getClass()
            );
        }
}
