package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.entity.MicroPlantEntity;
import by.fyodorov.servletproject.entity.UsualPlantEntity;
import by.fyodorov.servletproject.entity.WildPlantEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.LinkedList;

import static by.fyodorov.servletproject.parser.FlowerAttribute.*;

class SaxHandler extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger(SaxHandler.class);

    private LinkedList<AbstractPlantEntity> plants = new LinkedList<>();


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

    private byte node = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < attributes.getLength(); i++) {
            map.put(attributes.getQName(i), attributes.getValue(i));
        }
        startHandler(qName, map);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        endHandler(qName);
    }

    @Override
    public void characters(char ch[], int start, int length) {
        charactersHandler(new String(ch, start, length));
    }

    public LinkedList<AbstractPlantEntity> getPlants() {
        return plants;
    }

    public void startHandler(String qName, HashMap<String, String> map) {
        LOGGER.info("start element");
        LOGGER.info("length ==== " + map.size() + " NAME = " + qName);

        if (    FLOWER_NODE.getValue().equalsIgnoreCase(qName) ||
                USUAL_ATTRIBUTE.getValue().equalsIgnoreCase(qName) ||
                WILD_ATTRIBUTE.getValue().equalsIgnoreCase(qName) ||
                MICRO_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            id = Integer.valueOf(map.get(ID_ATTRIBUTE.getValue()));

        } else if (NAME_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = NAME_ATTRIBUTE.getCode();

        } else if (SOIL_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = SOIL_ATTRIBUTE.getCode();

        } else if (ORIGIN_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = ORIGIN_ATTRIBUTE.getCode();

        } else if (VISUAL_NODE.getValue().equalsIgnoreCase(qName)) {
            node = VISUAL_NODE.getCode();

        } else if (STALK_COLOR_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = STALK_COLOR_ATTRIBUTE.getCode();

        } else if (LEAF_COLOR_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = LEAF_COLOR_ATTRIBUTE.getCode();

        } else if (SIZE_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = SIZE_ATTRIBUTE.getCode();

        } else if (TIPS_NODE.getValue().equalsIgnoreCase(qName)) {
            node = TIPS_NODE.getCode();

        } else if (TEMPERATURE_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = TEMPERATURE_ATTRIBUTE.getCode();

        } else if (LIGHTING_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = LIGHTING_ATTRIBUTE.getCode();

        } else if (WATERING_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = WATERING_ATTRIBUTE.getCode();

        } else if (MULTIPLYING_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            node = MULTIPLYING_ATTRIBUTE.getCode();
        }
    }


    public void charactersHandler(String characters) {
        LOGGER.info("checking - " + characters);
        if (node == NAME_ATTRIBUTE.getCode()) {
            name = characters;
        } else if (node == SOIL_ATTRIBUTE.getCode()) {
            soil = characters;
        } else if (node == ORIGIN_ATTRIBUTE.getCode()) {
            origin = characters;
        } else if (node == STALK_COLOR_ATTRIBUTE.getCode()) {
            stalkColor = characters;
        } else if (node == LEAF_COLOR_ATTRIBUTE.getCode()) {
            leafColor = characters;
        } else if (node == SIZE_ATTRIBUTE.getCode()) {
            size = Double.valueOf(characters);
        } else if (node == TEMPERATURE_ATTRIBUTE.getCode()) {
            temperature = Double.valueOf(characters);
        } else if (node == LIGHTING_ATTRIBUTE.getCode()) {
            lighting = Boolean.valueOf(characters);
        } else if (node == WATERING_ATTRIBUTE.getCode()) {
            watering = Double.valueOf(characters);
        } else if (node == MULTIPLYING_ATTRIBUTE.getCode()) {
            multiplying = characters;
        }
        node = 0;
    }

    public void endHandler(String qName) {
        if (WILD_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            WildPlantEntity entity = new WildPlantEntity();
            entity.setStalkColor(stalkColor);
            entity.setLeafColor(leafColor);
            entity.setSize(size);
            fillFlower(entity);
            plants.addLast(entity);
            reset();
        }
        if (MICRO_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            MicroPlantEntity entity = new MicroPlantEntity();
            entity.setTemperature(temperature);
            entity.setLighting(lighting);
            entity.setWatering(watering);
            fillFlower(entity);
            plants.addLast(entity);
            reset();
        }
        if (USUAL_ATTRIBUTE.getValue().equalsIgnoreCase(qName)) {
            UsualPlantEntity entity = new UsualPlantEntity();
            entity.setStalkColor(stalkColor);
            entity.setLeafColor(leafColor);
            entity.setSize(size);
            entity.setTemperature(temperature);
            entity.setLighting(lighting);
            entity.setWatering(watering);
            fillFlower(entity);
            plants.addLast(entity);
            reset();
        }
    }

    private void fillFlower(AbstractPlantEntity entity) {
        entity.setId(id);
        entity.setName(name);
        entity.setSoil(soil);
        entity.setOrigin(origin);
        entity.setMultiplying(multiplying);
    }

    private void reset() {
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

        node = 0;
    }
}
