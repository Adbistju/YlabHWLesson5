import Adbistju.system.comparator.ComparatorByNoParams;
import Adbistju.system.comparator.ComparatorByRegular;
import Adbistju.system.comparator.ConverterMaskToRegular;
import org.junit.Assert;
import org.junit.Test;

public class TestComparatorAndConvertParams {
    @Test
    public void TestComparatorByNoParams(){
        ComparatorByNoParams comparator = new ComparatorByNoParams();
        Assert.assertEquals(comparator.check("aa"), true);
        Assert.assertEquals(comparator.check(null), true);
        Assert.assertEquals(comparator.check("testName"), true);
    }

    @Test
    public void TestComparatorByRegular(){
        ComparatorByRegular comparator = new ComparatorByRegular(".*?[a-z]{4}-\\d+\\.[a-z]+");
        System.out.println(comparator.check("file-77194797.xml"));
        System.out.println(comparator.check("file-10738242118.java"));
        System.out.println(comparator.check("7777777777.java"));
    }

    @Test
    public void TestComparatorByRegular1(){
        ComparatorByRegular comparator = new ComparatorByRegular("d(\\W|\\w)*1");
        Assert.assertEquals(comparator.check("dafsa1"), true);
        Assert.assertEquals(comparator.check("test21"), false);
        Assert.assertEquals(comparator.check("test2"), false);
    }

    @Test
    public void TestMaskComparator0(){
        String params = "`.*?[a-z]{4}-\\d+\\.[a-z]+`";
        char [] chars = params.toCharArray();
        String param = ConverterMaskToRegular.constructParam(chars);
        Assert.assertEquals(param, ".*?[a-z]{4}-\\d+\\.[a-z]+" );
    }

    @Test
    public void TestMaskComparator(){
        ComparatorByRegular comparator = new ComparatorByRegular(ConverterMaskToRegular.addParam("*.java"));
        Assert.assertEquals(comparator.check("Hello World.java"), true);
        Assert.assertEquals(comparator.check("Minecraft.java"), true);
        Assert.assertEquals(comparator.check("word.txt"), false);
    }

    @Test
    public void TestConverterMaskToRegular(){
        Assert.assertEquals(ConverterMaskToRegular.addParam("*.java"), ".*\\.java");
        Assert.assertEquals(ConverterMaskToRegular.addParam("file*.x?l"), "file.*\\.x.l");
        Assert.assertEquals(ConverterMaskToRegular.addParam("test"), "test");
    }


}
