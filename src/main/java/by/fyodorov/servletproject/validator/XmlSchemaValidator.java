package by.fyodorov.servletproject.validator;

import by.fyodorov.servletproject.exception.XmlException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlSchemaValidator {

    public boolean validate(String pathXsd, String pathXml) throws XmlException {
        File xmlFile = new File(pathXml);
        File xsdFile = new File(pathXsd);

        if (!xmlFile.exists()) {
            throw new XmlException("Xml file doesn't exist");
        }
        if (!xsdFile.exists()) {
            throw new XmlException("Xsd schema doesn't exist");
        }

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema();
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        }
        catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new XmlException("Can't read file", e);
        }
        return true;
    }
}
