package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.PlantEntity;
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

public class DomXmlParser implements XmlParser {
    private static final Logger LOGGER = LogManager.getLogger(DomXmlParser.class);

    private static final String FLOWER_NODE = "flower";

    private static final String ID_ATTRIBUTE = "id";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SOIL_ATTRIBUTE = "soil";
    private static final String ORIGIN_ATTRIBUTE = "origin";

    private static final String VISUAL_NODE = "visualParameters";

    private static final String STALK_COLOR_ATTRIBUTE = "stalkColor";
    private static final String LEAF_COLOR_ATTRIBUTE = "leafColor";
    private static final String SIZE_ATTRIBUTE = "size";

    private static final String TIPS_NODE = "growingTips";

    private static final String TEMPERATURE_ATTRIBUTE = "temperature";
    private static final String LIGHTING_ATTRIBUTE = "lighting";
    private static final String WATERING_ATTRIBUTE = "watering";
    private static final String MULTIPLYING_ATTRIBUTE = "multiplying";


    /**
     * Parse XML file for getting array of people, saving in file
     *
     * @param path the path of xml file for parse
     * @return the array of people in xml file (path)
     */
    public LinkedList<PlantEntity> parseFile(String path) throws XmlException {
        try {
            File inputFile = new File(path);
            if (!inputFile.exists()) {
                throw new XmlException("File = \"" + path + "\" doesn't exist");
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(FLOWER_NODE);
            LinkedList<PlantEntity> list = new LinkedList<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                list.add(parseFromXML(nList.item(temp)));
            }
            return list;
        } catch (ParserConfigurationException e) {
            throw new XmlException("Invalid configuration", e);
        } catch (IOException e) {
            throw new XmlException("File can't read", e);
        } catch (SAXException e) {
            throw new XmlException("Sax exception", e);
        }
    }

    /**
     * Parse XML file for getting user with @param index from this xml file
     *
     * @param node  the path of xml file for parsing
     * @return the user with @param index
     */
    private PlantEntity parseFromXML(Node node) {
        int id = 0;
        String name = null;
        String soil = null;
        String origin = null;
        String stalkColor = null;
        String leafColor = null;
        double size = 0;
        double temperature = 0;
        boolean lighting = false;
        double watering = 0;
        String multiplying = null;

        Element flower = (Element) node;
        id = Integer.valueOf(flower.getAttribute(ID_ATTRIBUTE));
        name = getXMLArgument(node, NAME_ATTRIBUTE);
        soil = getXMLArgument(node, SOIL_ATTRIBUTE);
        origin = getXMLArgument(node, ORIGIN_ATTRIBUTE);

        Node visualNode = flower.getElementsByTagName(VISUAL_NODE).item(0);
        if (visualNode.getNodeType() == Node.ELEMENT_NODE) {
            stalkColor = getXMLArgument(visualNode, STALK_COLOR_ATTRIBUTE);
            leafColor = getXMLArgument(visualNode, LEAF_COLOR_ATTRIBUTE);
            size = Double.valueOf(getXMLArgument(visualNode, SIZE_ATTRIBUTE));
        }
        Node growingNode = flower.getElementsByTagName(TIPS_NODE).item(0);
        if (growingNode.getNodeType() == Node.ELEMENT_NODE) {
            temperature = Double.valueOf(getXMLArgument(growingNode, TEMPERATURE_ATTRIBUTE));
            lighting = Boolean.valueOf(getXMLArgument(growingNode, LIGHTING_ATTRIBUTE));
            watering = Double.valueOf(getXMLArgument(growingNode, WATERING_ATTRIBUTE));
        }

        multiplying = getXMLArgument(node, MULTIPLYING_ATTRIBUTE);
        return new PlantEntity(id, name, soil, origin, stalkColor, leafColor, size, temperature, lighting, watering, multiplying);
    }


    /**
     * private method for getting value of attribute from Node in XML file
     *
     * @param node     the Node in XML file
     * @param attribute the name of attribute to getting it value
     * @return the value of this argument
     */
    private static String getXMLArgument(Node node, String attribute) {
        LOGGER.info("getting attribute = \"" + attribute + "\"");
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getElementsByTagName(attribute).item(0).getTextContent();
        }
        return null;
    }
}
