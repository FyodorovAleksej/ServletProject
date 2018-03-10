package by.fyodorov.servletproject.validator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlSchemaValidatorTest {
    private static final String XML_PATH = "input/input.xml";
    private static final String XSD_PATH = "input/flowersValidation.xsd";

    @Test
    public void testValidate() throws Exception {
        XmlSchemaValidator validator = new XmlSchemaValidator();
        Assert.assertTrue(validator.validate(XSD_PATH, XML_PATH));
    }
}