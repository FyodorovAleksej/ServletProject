package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.PlantEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;

class SaxHandler extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger(SaxHandler.class);

    private LinkedList<PlantEntity> plants = new LinkedList<>();

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

    private int id = 0;
    private String name = null;
    private String soil = null;
    private String origin = null;
    private String stalkColor = null;
    private String leafColor = null;
    private double size = 0;
    private double temperature = 0;
    private boolean lighting = false;
    private double watering = 0;
    private String multiplying = null;

    private boolean bName = false;
    private boolean bSoil = false;
    private boolean bOrigin = false;
    private boolean bStalkColor = false;
    private boolean bLeafColor = false;
    private boolean bSize = false;
    private boolean bTemperature = false;
    private boolean bLighting = false;
    private boolean bWatering = false;
    private boolean bMultiplying = false;

    private boolean bVisual = false;
    private boolean bTips = false;

    private int count = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        LOGGER.info("start element");
        LOGGER.info("length ==== " + attributes.getLength() + " NAME = " + qName);
        if (qName.equalsIgnoreCase(FLOWER_NODE)) {
            id = Integer.valueOf(attributes.getValue(ID_ATTRIBUTE));
        } else if (qName.equalsIgnoreCase(NAME_ATTRIBUTE)) {
            bName = true;
            count++;
        } else if (qName.equalsIgnoreCase(SOIL_ATTRIBUTE)) {
            bSoil = true;
            count++;
        } else if (qName.equalsIgnoreCase(ORIGIN_ATTRIBUTE)) {
            bOrigin = true;
            count++;
        } else if (qName.equalsIgnoreCase(VISUAL_NODE)) {
            bVisual = true;
        } else if (qName.equalsIgnoreCase(STALK_COLOR_ATTRIBUTE)) {
            bStalkColor = true;
            count++;
        } else if (qName.equalsIgnoreCase(LEAF_COLOR_ATTRIBUTE)) {
            bLeafColor = true;
            count++;
        } else if (qName.equalsIgnoreCase(SIZE_ATTRIBUTE)) {
            bSize = true;
            count++;
        } else if (qName.equalsIgnoreCase(TIPS_NODE)) {
            bTips = true;
        } else if (qName.equalsIgnoreCase(TEMPERATURE_ATTRIBUTE)) {
            bTemperature = true;
            count++;
        } else if (qName.equalsIgnoreCase(LIGHTING_ATTRIBUTE)) {
            bLighting = true;
            count++;
        } else if (qName.equalsIgnoreCase(WATERING_ATTRIBUTE)) {
            bWatering = true;
            count++;
        } else if (qName.equalsIgnoreCase(MULTIPLYING_ATTRIBUTE)) {
            bMultiplying = true;
            count++;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        LOGGER.info("checking - " + new String(ch,start,length));
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bSoil) {
            soil = new String(ch, start, length);
            bSoil = false;
        } else if (bOrigin) {
            origin = new String(ch, start, length);
            bOrigin = false;
        } else if (bStalkColor) {
            stalkColor = new String(ch, start, length);
            bStalkColor = false;
        } else if (bLeafColor) {
            leafColor = new String(ch, start, length);
            bLeafColor = false;
        } else if (bSize) {
            size = Double.valueOf(new String(ch, start, length));
            bSize = false;
        } else if (bVisual) {
            bVisual = false;
        } else if (bTemperature) {
            temperature = Double.valueOf(new String(ch, start, length));
            bTemperature = false;
        } else if (bLighting) {
            lighting = Boolean.valueOf(new String(ch, start, length));
            bLighting = false;
        } else if (bWatering) {
            watering = Double.valueOf(new String(ch, start, length));
            bWatering = false;
        } else if (bMultiplying) {
            multiplying = new String(ch, start, length);
            bMultiplying = false;
        } else if (bTips) {
            bTips = false;
        }

        if (count == 10) {
            plants.addLast(new PlantEntity(id, name, soil, origin, stalkColor, leafColor, size, temperature, lighting, watering, multiplying));

            bName = false;
            bSoil = false;
            bOrigin = false;
            bStalkColor = false;
            bLeafColor = false;
            bSize = false;
            bTemperature = false;
            bLighting = false;
            bWatering = false;
            bMultiplying = false;
            bVisual = false;
            bTips = false;

            id = 0;
            name = null;
            soil = null;
            origin = null;
            stalkColor = null;
            leafColor = null;
            size = 0;
            temperature = 0;
            lighting = false;
            watering = 0;
            multiplying = null;

            count = 0;
        }
    }

    public LinkedList<PlantEntity> getPlants() {
        return plants;
    }
}
