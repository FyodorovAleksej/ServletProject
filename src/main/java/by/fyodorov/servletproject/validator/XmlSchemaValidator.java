package by.fyodorov.servletproject.validator;

import by.fyodorov.servletproject.exception.XmlException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * class for validating XML file with XSD file
 */
public class XmlSchemaValidator {
    private static final Logger LOGGER = LogManager.getLogger(XmlSchemaValidator.class);

    /**
     * validating XML file by XSD scheme
     * @param pathXsd - path to XSD scheme
     * @param pathXml - path to XML file
     * @return did XML file valid?
     * @throws XmlException - if can't read XSD or XML file
     */
    public boolean validate(String pathXsd, String pathXml) throws XmlException {
        File xmlFile = new File(pathXml);
        File xsdFile = new File(pathXsd);
        LOGGER.info("xml = \"" + pathXml + "\"; xsd = \"" + pathXsd + "\"");
        if (!xmlFile.exists()) {
            throw new XmlException("Xml file doesn't exist. Path = \"" + pathXml + "\"");
        }
        if (!xsdFile.exists()) {
            throw new XmlException("Xsd schema doesn't exist. Path = \"" + pathXsd + "\"");
        }

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema();
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        }
        catch (SAXException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            throw new XmlException("Can't read file", e);
        }
        return true;
    }
}
