package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * class of wild flower
 */
@XmlType(propOrder = {"name", "soil", "origin", "multiplying", "stalkColor", "leafColor", "size"}, name = "wild")
@XmlRootElement(name = "wild")
public class WildPlantEntity extends AbstractPlantEntity {
    private static final String TYPE = "wild";
    private PlantVisualEntity visualEntity;

    public WildPlantEntity() {
        this.visualEntity = new PlantVisualEntity();
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

    @Override
    public String toString() {
        return  "id = " + Integer.toString(id) +
                "; name = " + name +
                "; soil = " + soil +
                "; origin = " + origin +
                "; " + visualEntity +
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
        WildPlantEntity entity = (WildPlantEntity) obj;
        return  this.id == entity.id &&
                this.name.equals(entity.name) &&
                this.soil.equals(entity.soil) &&
                this.origin.equals(entity.origin) &&
                this.visualEntity.equals(entity.visualEntity) &&
                this.multiplying.equals(entity.multiplying);
    }

    @Override
    public int hashCode() {
        return  Integer.hashCode(id) +
                name.hashCode() +
                soil.hashCode() +
                origin.hashCode() +
                visualEntity.hashCode() +
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
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + NONE_VALUE +       CELL_SEPARATOR_END +
                CELL_SEPARATOR_START + getMultiplying() + CELL_SEPARATOR_END + LINE_END;
    }

}
