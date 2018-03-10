package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.entity.WildPlantEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class StaxXmlParserTest {
    private static final String XML_PATH = "input/input.xml";

    @Test
    public void testParseFile() throws Exception {
        XmlParser parser = new StaxXmlParser();
        LinkedList<AbstractPlantEntity> list = parser.parseFile(XML_PATH);
        AbstractPlantEntity actual = list.getFirst();WildPlantEntity expected = new WildPlantEntity();
        expected.setId(0);
        expected.setName("chamomile");
        expected.setSoil("ground");
        expected.setOrigin("Europe");
        expected.setStalkColor("green");
        expected.setLeafColor("white");
        expected.setSize(20);
        expected.setMultiplying("seeds");
        Assert.assertEquals(actual,expected);
    }
}