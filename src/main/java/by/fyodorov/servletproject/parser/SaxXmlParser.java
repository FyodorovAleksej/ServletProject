package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * class for SAX parsing
 */
public class SaxXmlParser implements XmlParser {
    private static final Logger LOGGER = LogManager.getLogger(SaxXmlParser.class);

    /**
     * parsing file to list of flowers
     * @param path - path of XML file for parsing
     * @return - list of flowers from this XML file
     * @throws XmlException - if can't read file for parsing
     */
    @Override
    public LinkedList<AbstractPlantEntity> parseFile (String path) throws XmlException {
        try {
            LOGGER.info("Sax parsing file = \"" + path + "\"");
            File inputFile = new File(path);
            if (!inputFile.exists()) {
                throw new XmlException("file doesn't exist");
            }
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(inputFile, handler);

            return handler.getPlants();
        } catch (ParserConfigurationException | SAXException e) {
            throw new XmlException("Configuration fail", e);
        } catch (IOException e) {
            throw new XmlException("Can't open file = \"" + path + "\"", e);
        }
    }
}

