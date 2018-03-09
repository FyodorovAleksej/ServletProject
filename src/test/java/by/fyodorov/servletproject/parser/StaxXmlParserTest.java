package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class StaxXmlParserTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testParseFile() throws Exception {
        XmlParser parser = new StaxXmlParser();
        LinkedList<AbstractPlantEntity> list = parser.parseFile("input/input.xml");
        AbstractPlantEntity actual = list.getFirst();
        //AbstractPlantEntity expected = new AbstractPlantEntity(0, "chamomile","ground","Eurasia", "green", "white", 20, 14, true,20, "seeds");
        //Assert.assertEquals(actual,expected);
    }
}