package by.fyodorov.servletproject.validator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlSchemaValidatorTest {

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidate() throws Exception {
        XmlSchemaValidator validator = new XmlSchemaValidator();
        Assert.assertTrue(validator.validate("input/flowersValidation.xsd", "input/input.xml"));
    }
}