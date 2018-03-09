package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.entity.WildPlantEntity;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class SaxXmlParserTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseFile() throws Exception {
        XmlParser parser = new SaxXmlParser();
        LinkedList<AbstractPlantEntity> list = parser.parseFile("input/input.xml");
        AbstractPlantEntity actual = list.getFirst();
        WildPlantEntity expected = new WildPlantEntity();
        expected.setId(0);
        expected.setName("chamomile");
        expected.setSoil("ground");
        expected.setOrigin("Eurasia");
        expected.setStalkColor("green");
        expected.setLeafColor("white");
        expected.setSize(20);
        expected.setMultiplying("seeds");
        Assert.assertEquals(actual,expected);
        System.out.println(list.getLast());
    }
}