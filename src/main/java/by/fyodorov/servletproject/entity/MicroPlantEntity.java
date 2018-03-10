package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * class of micro flowers
 */
@XmlType(propOrder = {"name", "soil", "origin", "multiplying", "temperature", "lighting", "watering"}, name = "micro")
@XmlRootElement(name = "micro")
public class MicroPlantEntity extends AbstractPlantEntity {
    private static final String TYPE = "micro";

    @XmlElement(name = "growingTips")
    private PlantTipEntity tipEntity;

    public MicroPlantEntity() {
        this.tipEntity = new PlantTipEntity();
    }

    /**
     * getting temperature
     * @return - temperature for current flower
     */
    public double getTemperature() {
        return tipEntity.getTemperature();
    }

    /**
     * getting lighting
     * @return - lighting for current flower
     */
    public boolean isLighting() {
        return tipEntity.isLighting();
    }

    /**
     * getting watering
     * @return - count of watering for current flower
     */
    public double getWatering() {
        return tipEntity.getWatering();
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
     * @param watering - count of watering for current flower
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
        MicroPlantEntity entity = (MicroPlantEntity) obj;
        return  this.id == entity.id &&
                this.name.equals(entity.name) &&
                this.soil.equals(entity.soil) &&
                this.origin.equals(entity.origin) &&
                this.tipEntity.equals(entity.tipEntity) &&
                this.multiplying.equals(entity.multiplying);
    }

    @Override
    public int hashCode() {
        return  Integer.hashCode(id) +
                name.hashCode() +
                soil.hashCode() +
                origin.hashCode() +
                tipEntity.hashCode() +
                multiplying.hashCode();
    }


    /**
     * transform flower object to format for table in HTML
     * @return string for HTML table
     */
    @Override
    public String toHtml() {
        return  LINE_START + CELL_SEPARATOR_START + getId() + CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + TYPE +             CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getName() +        CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getSoil() +        CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getOrigin() +      CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getTemperature() + CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + isLighting() +     CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getWatering() +    CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getMultiplying() + CELL_SEPARATOR_END + LINE_END;
    }
}
