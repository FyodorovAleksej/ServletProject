package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.PlantEntity;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

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
        LinkedList<PlantEntity> list = parser.parseFile("input/input.xml");
        PlantEntity actual = list.getFirst();
        PlantEntity expected = new PlantEntity(0, "chamomile","ground","Eurasia", "green", "white", 20, 14, true,20, "seeds");
        Assert.assertEquals(actual,expected);
        System.out.println(list.getLast());
    }
}