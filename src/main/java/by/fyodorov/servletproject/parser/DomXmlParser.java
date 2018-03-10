package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.comporator.PlantAbstractComparator;
import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.entity.MicroPlantEntity;
import by.fyodorov.servletproject.entity.UsualPlantEntity;
import by.fyodorov.servletproject.entity.WildPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static by.fyodorov.servletproject.parser.FlowerAttribute.*;

/**
 * class for DOM parsing file
 */
public class DomXmlParser implements XmlParser {
    private static final Logger LOGGER = LogManager.getLogger(DomXmlParser.class);


    /**
     * parsing file to list of flowers
     * @param path - path of XML file for parsing
     * @return - list of flowers from this XML file
     * @throws XmlException - if can't read file for parsing
     */
    public LinkedList<AbstractPlantEntity> parseFile(String path) throws XmlException {
        try {
            LOGGER.info("start parsing file = \"" + path + "\"");
            File inputFile = new File(path);
            if (!inputFile.exists()) {
                throw new XmlException("File = \"" + path + "\" doesn't exist");
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
            LinkedList<AbstractPlantEntity> abstractPlantEntities = new LinkedList<>();

            NodeList usualPlantList = document.getElementsByTagName(USUAL_ATTRIBUTE.getValue());
            for (int temp = 0; temp < usualPlantList.getLength(); temp++) {
                abstractPlantEntities.add(parseFromXML(usualPlantList.item(temp)));
            }

            NodeList wildPlantList = document.getElementsByTagName(WILD_ATTRIBUTE.getValue());
            for (int temp = 0; temp < wildPlantList.getLength(); temp++) {
                abstractPlantEntities.add(parseFromXML(wildPlantList.item(temp)));
            }

            NodeList microPlantList = document.getElementsByTagName(MICRO_ATTRIBUTE.getValue());
            for (int temp = 0; temp < microPlantList.getLength(); temp++) {
                abstractPlantEntities.add(parseFromXML(microPlantList.item(temp)));
            }

            abstractPlantEntities.sort(new PlantAbstractComparator());
            return abstractPlantEntities;

        } catch (ParserConfigurationException e) {
            throw new XmlException("Invalid configuration", e);
        } catch (IOException e) {
            throw new XmlException("File can't read", e);
        } catch (SAXException e) {
            throw new XmlException("Sax exception", e);
        }
    }


    /**
     * parsing node of XML file to flower
     * @param node - node of XML file
     * @return created flower
     */
    private AbstractPlantEntity parseFromXML(Node node) {
        Element element = (Element) node;
        if (WILD_ATTRIBUTE.getValue().equals(element.getTagName())) {
            WildPlantEntity wildEntity = new WildPlantEntity();
            wildEntity.setStalkColor(getXMLArgument(node, STALK_COLOR_ATTRIBUTE.getValue()));
            wildEntity.setLeafColor(getXMLArgument(node, LEAF_COLOR_ATTRIBUTE.getValue()));
            wildEntity.setSize(Double.valueOf(getXMLArgument(node, SIZE_ATTRIBUTE.getValue())));
            fillFlower(wildEntity, node);
            return wildEntity;
        }
        if (MICRO_ATTRIBUTE.getValue().equals(element.getTagName())) {
            MicroPlantEntity microEntity = new MicroPlantEntity();
            microEntity.setTemperature(Double.valueOf(getXMLArgument(node, TEMPERATURE_ATTRIBUTE.getValue())));
            microEntity.setLighting(Boolean.valueOf(getXMLArgument(node, LIGHTING_ATTRIBUTE.getValue())));
            microEntity.setWatering(Double.valueOf(getXMLArgument(node, WATERING_ATTRIBUTE.getValue())));
            fillFlower(microEntity, node);
            return microEntity;
        }
        if (USUAL_ATTRIBUTE.getValue().equals(element.getTagName())) {
            UsualPlantEntity usualEntity = new UsualPlantEntity();
            usualEntity.setStalkColor(getXMLArgument(node, STALK_COLOR_ATTRIBUTE.getValue()));
            usualEntity.setLeafColor(getXMLArgument(node, LEAF_COLOR_ATTRIBUTE.getValue()));
            usualEntity.setSize(Double.valueOf(getXMLArgument(node, SIZE_ATTRIBUTE.getValue())));
            usualEntity.setTemperature(Double.valueOf(getXMLArgument(node, TEMPERATURE_ATTRIBUTE.getValue())));
            usualEntity.setLighting(Boolean.valueOf(getXMLArgument(node, LIGHTING_ATTRIBUTE.getValue())));
            usualEntity.setWatering(Double.valueOf(getXMLArgument(node, WATERING_ATTRIBUTE.getValue())));
            fillFlower(usualEntity, node);
            return usualEntity;
        }
        return null;
    }

    /**
     * filling flower with parameters
     * @param entity - entity for filling
     * @param node - node with information
     */
    private void fillFlower(AbstractPlantEntity entity, Node node) {
        entity.setId(Integer.valueOf(((Element)node).getAttribute(ID_ATTRIBUTE.getValue())));
        entity.setName(getXMLArgument(node, NAME_ATTRIBUTE.getValue()));
        entity.setSoil(getXMLArgument(node, SOIL_ATTRIBUTE.getValue()));
        entity.setOrigin(getXMLArgument(node, ORIGIN_ATTRIBUTE.getValue()));
        entity.setMultiplying(getXMLArgument(node, MULTIPLYING_ATTRIBUTE.getValue()));
    }

    /**
     * getting XML argument from node with name of attribute
     * @param node - node with information
     * @param attribute - name for getting attribute
     * @return the value of attribute
     */
    private static String getXMLArgument(Node node, String attribute) {
        LOGGER.info("getting attribute = \"" + attribute + "\"");
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getElementsByTagName(attribute).item(0).getTextContent();
        }
        return "";
    }
}
