package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.PlantEntity;
import by.fyodorov.servletproject.exception.XmlException;

import java.util.LinkedList;

public interface XmlParser {
    LinkedList<PlantEntity> parseFile(String path) throws XmlException;
}
