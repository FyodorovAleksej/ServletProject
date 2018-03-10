package by.fyodorov.servletproject.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * class of usual flower
 */
@XmlType(propOrder = {"name", "soil", "origin", "multiplying", "stalkColor", "leafColor", "size", "temperature", "lighting", "watering"}, name = "usual")
@XmlRootElement(name = "usual")
public class UsualPlantEntity extends AbstractPlantEntity {
    private static final String TYPE = "usual";

    @XmlElement(name = "visualParameters")
    private PlantVisualEntity visualEntity;
    @XmlElement(name = "growingTips")
    private PlantTipEntity tipEntity;

    public UsualPlantEntity() {
        this.visualEntity = new PlantVisualEntity();
        this.tipEntity = new PlantTipEntity();
    }

    /**
     * getting stalkColor
     * @return - color of stalk of current flower
     */
    public String getStalkColor() {
        return visualEntity.getStalkColor();
    }

    /**
     * getting leafColor
     * @return - color of leaf of current flower
     */
    public String getLeafColor() {
        return visualEntity.getLeafColor();
    }

    /**
     * getting size
     * @return - size of current flower
     */
    public double getSize() {
        return visualEntity.getSize();
    }

    /**
     * getting temperature
     * @return - temperature of current flower
     */
    public double getTemperature() {
        return tipEntity.getTemperature();
    }

    /**
     * getting lighting
     * @return - lighting of current flower
     */
    public boolean isLighting() {
        return tipEntity.isLighting();
    }

    /**
     * getting watering
     * @return - count of water for current flower
     */
    public double getWatering() {
        return tipEntity.getWatering();
    }


    /**
     * setting stalkColor
     * @param stalkColor - color of stalk of current flower
     */
    public void setStalkColor(String stalkColor) {
        visualEntity.setStalkColor(stalkColor);
    }

    /**
     * setting leafColor
     * @param leafColor - color of leaf of current flower
     */
    public void setLeafColor(String leafColor) {
        visualEntity.setLeafColor(leafColor);
    }

    /**
     * setting size
     * @param size - size of current flower
     */
    public void setSize(double size) {
        visualEntity.setSize(size);
    }

    /**
     * setting temperature
     * @param temperature - temperature for current flower
     */
    public void setTemperature(double temperature) {
        tipEntity.setTemperature(temperature);
    }

    /**
     * setting lighting
     * @param lighting - lighting for current flower
     */
    public void setLighting(boolean lighting) {
        tipEntity.setLighting(lighting);
    }

    /**
     * setting watering
     * @param watering - count of water for current flower
     */
    public void setWatering(double watering) {
        tipEntity.setWatering(watering);
    }


    @Override
    public String toString() {
        return  "id = " + Integer.toString(id) +
                "; name = " + name +
                "; soil = " + soil +
                "; origin = " + origin +
                "; " + visualEntity +
                "; " + tipEntity +
                "; multiplying = " + multiplying + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        UsualPlantEntity entity = (UsualPlantEntity) obj;
        return  this.id == entity.id &&
                this.name.equals(entity.name) &&
                this.soil.equals(entity.soil) &&
                this.origin.equals(entity.origin) &&
                this.visualEntity.equals(entity.visualEntity) &&
                this.tipEntity.equals(entity.tipEntity) &&
                this.multiplying.equals(entity.multiplying);
    }

    @Override
    public int hashCode() {
        return  Integer.hashCode(id) +
                name.hashCode() +
                soil.hashCode() +
                origin.hashCode() +
                visualEntity.hashCode() +
                tipEntity.hashCode() +
                multiplying.hashCode();
    }

    /**
     * transform current flower to format for HTML table
     * @return form for HTML table
     */
    @Override
    public String toHtml() {
        return  LINE_START + CELL_SEPARATOR_START + getId() + CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + TYPE +             CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getName() +        CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getSoil() +        CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getOrigin() +      CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getStalkColor() +  CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getLeafColor() +   CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getSize() +        CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getTemperature() + CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + isLighting() +     CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getWatering() +    CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getMultiplying() + CELL_SEPARATOR_END + LINE_END;
    }
}
