package by.fyodorov.servletproject.entity;

/**
 * Abstract class of flower
 */
public abstract class AbstractPlantEntity {
    static final String LINE_START = "<tr>";
    static final String LINE_END = "</tr>";
    static final String CELL_SEPARATOR_START = "<th>";
    static final String CELL_SEPARATOR_END = "</th>";
    static final String NONE_VALUE = "-";

    int id;
    String name;
    String soil;
    String origin;
    String multiplying;

    /**
     * getting ID
     * @return ID of current flower
     */
    public int getId() {
        return id;
    }

    /**
     * getting name
     * @return name of current flower
     */
    public String getName() {
        return name;
    }

    /**
     * getting soil
     * @return soil of current flower
     */
    public String getSoil() {
        return soil;
    }

    /**
     * getting origin
     * @return origin of current flower
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * getting kind of multiplying
     * @return kind of multiplying of current flower
     */
    public String getMultiplying() {
        return multiplying;
    }

    /**
     * setting ID
     * @param id - id for current flower
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * setting name
     * @param name - name for current flower
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setting soil
     * @param soil - soil for current flower
     */
    public void setSoil(String soil) {
        this.soil = soil;
    }

    /**
     * setting origin
     * @param origin - origin for current flower
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * setting kind of multiplying
     * @param multiplying - kind of multiplying
     */
    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    /**
     * transform flower object to format for table in HTML
     * @return string for HTML table
     */
    public abstract String toHtml();
}
