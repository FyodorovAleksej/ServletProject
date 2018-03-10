package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * class of VisualParameters
 */
@XmlType(propOrder = {"stalkColor", "leafColor", "size"}, name = "visualParameters")
public class PlantVisualEntity {
    @XmlElement
    private String stalkColor;
    @XmlElement
    private String leafColor;
    @XmlElement
    private double size;

    public PlantVisualEntity() {

    }

    /**
     * getting stalkColor
     * @return - color of stalk of current flower
     */
    public String getStalkColor() {
        return stalkColor;
    }

    /**
     * getting leafColor
     * @return - color of leaf of current flower
     */
    public String getLeafColor() {
        return leafColor;
    }

    /**
     * getting size
     * @return - size of current flower
     */
    public double getSize() {
        return size;
    }


    /**
     * setting stalkColor
     * @param stalkColor - color of stalk
     */
    public void setStalkColor(String stalkColor) {
        this.stalkColor = stalkColor;
    }

    /**
     * setting leafColor
     * @param leafColor - color of leaf
     */
    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    /**
     * setting size
     * @param size - size for current flower
     */
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
