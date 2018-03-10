package by.fyodorov.servletproject.parser;

/**
 * enum with parameters into XML
 */
public enum FlowerAttribute {
    WILD_ATTRIBUTE("wild"),
    MICRO_ATTRIBUTE("micro"),
    USUAL_ATTRIBUTE("usual"),

    ID_ATTRIBUTE("id"),
    NAME_ATTRIBUTE("name"),
    SOIL_ATTRIBUTE("soil"),
    ORIGIN_ATTRIBUTE("origin"),

    VISUAL_NODE("visualParameters"),
    STALK_COLOR_ATTRIBUTE("stalkColor"),
    LEAF_COLOR_ATTRIBUTE("leafColor"),
    SIZE_ATTRIBUTE("size"),

    TIPS_NODE("growingTips"),
    TEMPERATURE_ATTRIBUTE("temperature"),
    LIGHTING_ATTRIBUTE("lighting"),
    WATERING_ATTRIBUTE("watering"),
    MULTIPLYING_ATTRIBUTE("multiplying");

    private String value;

    FlowerAttribute(String value) {
        this.value = value;
    }

    /**
     * getting value for quality attribute
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * getting code for SAX parser for identity attribute in SAX parser
     * @return code for parameter
     */
    public byte getCode() {
        return (byte) ordinal();
    }
}
