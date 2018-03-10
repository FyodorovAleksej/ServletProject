package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * class for StAX parsing
 */
public class StaxXmlParser implements XmlParser {

    private static final Logger LOGGER = LogManager.getLogger(StaxXmlParser.class);

    /**
     * parsing file to list of flowers
     * @param path - path of XML file for parsing
     * @return - list of flowers from this XML file
     * @throws XmlException - if can't read file for parsing
     */
    @Override
    public LinkedList<AbstractPlantEntity> parseFile(String path) throws XmlException {
        LOGGER.info("Stax parsing file = \"" + path + "\"");
        SaxHandler handler = new SaxHandler();

        try {
            XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = xmlFactory.createXMLEventReader(new FileReader(path));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        Iterator attributeIterator = startElement.getAttributes();
                        HashMap<String, String> attributeMap = new HashMap<>();
                        while (attributeIterator.hasNext()) {
                            Attribute attribute = (Attribute) attributeIterator.next();
                            attributeMap.put(attribute.getName().getLocalPart(), attribute.getValue());
                        }
                        handler.commonStartHandler(qName, attributeMap);
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        Characters characters = event.asCharacters();
                        handler.commonCharactersHandler(characters.getData());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        EndElement endElement = event.asEndElement();
                        handler.commonEndHandler(endElement.getName().getLocalPart());
                        break;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new XmlException("Can't open file for parsing", e);
        }
        return handler.getPlants();
    }
}
