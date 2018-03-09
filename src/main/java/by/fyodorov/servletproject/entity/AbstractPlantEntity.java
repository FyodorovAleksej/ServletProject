package by.fyodorov.servletproject.entity;

//@XmlType(propOrder = { "id", "name", "soil", "origin", "visualEntity", "tipEntity", "multiplying"}, name = "flower")
//@XmlRootElement(name = "flower")
public abstract class AbstractPlantEntity {
    protected int id;
    protected String name;
    protected String soil;
    protected String origin;
    protected String multiplying;


    public AbstractPlantEntity() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSoil() {
        return soil;
    }
    public String getOrigin() {
        return origin;
    }
    public String getMultiplying() {
        return multiplying;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSoil(String soil) {
        this.soil = soil;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }


    public abstract String toHtml();
}
