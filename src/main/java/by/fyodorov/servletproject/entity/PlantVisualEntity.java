package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"stalkColor", "leafColor", "size"}, name = "visualParameters")
public class PlantVisualEntity {
    @XmlElement
    private String stalkColor;
    @XmlElement
    private String leafColor;
    @XmlElement
    private double size;

    public PlantVisualEntity() {
        this("NONE", "NONE", 0);
    }

    public PlantVisualEntity(String stalkColor, String leafColor, double size) {
        this.stalkColor = stalkColor;
        this.leafColor = leafColor;
        this.size = size;
    }


    public String getStalkColor() {
        return stalkColor;
    }
    public String getLeafColor() {
        return leafColor;
    }
    public double getSize() {
        return size;
    }


    public void setStalkColor(String stalkColor) {
        this.stalkColor = stalkColor;
    }
    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }
    public void setSize(double size) {
        this.size = size;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PlantVisualEntity entity = (PlantVisualEntity) obj;
        return  this.stalkColor.equals(entity.stalkColor) &&
                this.leafColor.equals(entity.leafColor) &&
                this.size == entity.size;
    }

    @Override
    public int hashCode() {
        return  stalkColor.hashCode() +
                leafColor.hashCode() +
                Double.hashCode(size);
    }

    @Override
    public String toString() {
        return  "stalk Color = \"" + stalkColor + "\"" +
                "; leaf Color = \"" + leafColor + "\"" +
                "; size = " + size;
    }
}
