package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;

import java.util.LinkedList;

/**
 * interface for parsing XML file
 */
public interface XmlParser {
    LinkedList<AbstractPlantEntity> parseFile(String path) throws XmlException;
}
