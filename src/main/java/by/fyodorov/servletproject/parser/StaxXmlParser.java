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

public class StaxXmlParser implements XmlParser {

    private static final Logger LOGGER = LogManager.getLogger(StaxXmlParser.class);

    @Override
    public LinkedList<AbstractPlantEntity> parseFile(String path) throws XmlException {
        SaxHandler handler = new SaxHandler();

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(path));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        Iterator iterator = startElement.getAttributes();
                        HashMap<String, String> map = new HashMap<>();
                        while (iterator.hasNext()) {
                            Attribute attribute = (Attribute) iterator.next();
                            map.put(attribute.getName().getLocalPart(), attribute.getValue());
                            LOGGER.debug("key = \"" + attribute.getName() + "\"; value = \"" + attribute.getValue() + "\"");
                        }
                        handler.startHandler(qName, map);
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        Characters characters = event.asCharacters();
                        handler.charactersHandler(characters.getData());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        EndElement endElement = event.asEndElement();
                        handler.endHandler(endElement.getName().getLocalPart());
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
