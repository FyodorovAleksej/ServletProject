package by.fyodorov.servletproject.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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

    public String getStalkColor() {
        return visualEntity.getStalkColor();
    }
    public String getLeafColor() {
        return visualEntity.getLeafColor();
    }
    public double getSize() {
        return visualEntity.getSize();
    }
    public double getTemperature() {
        return tipEntity.getTemperature();
    }
    public boolean isLighting() {
        return tipEntity.isLighting();
    }
    public double getWatering() {
        return tipEntity.getWatering();
    }


    public void setStalkColor(String stalkColor) {
        visualEntity.setStalkColor(stalkColor);
    }
    public void setLeafColor(String leafColor) {
        visualEntity.setLeafColor(leafColor);
    }
    public void setSize(double size) {
        visualEntity.setSize(size);
    }
    public void setTemperature(double temperature) {
        tipEntity.setTemperature(temperature);
    }
    public void setLighting(boolean lighting) {
        tipEntity.setLighting(lighting);
    }
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
