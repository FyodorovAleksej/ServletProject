package by.fyodorov.servletproject.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlSchemaValidatorTest {
    private static final String XML_PATH = "src/main/webapp/xml/flowersStorage.xml";
    private static final String XSD_PATH = "src/main/webapp/xml/flowersValidation.xsd";

    @Test
    public void testValidate() throws Exception {
        XmlSchemaValidator validator = new XmlSchemaValidator();
        Assert.assertTrue(validator.validate(XSD_PATH, XML_PATH));
    }
}