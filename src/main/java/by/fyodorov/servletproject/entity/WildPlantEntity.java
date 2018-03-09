package by.fyodorov.servletproject.entity;

public class WildPlantEntity extends AbstractPlantEntity {
    private PlantVisualEntity visualEntity;

    public WildPlantEntity() {
        this.visualEntity = new PlantVisualEntity();
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


    public void setStalkColor(String stalkColor) {
        visualEntity.setStalkColor(stalkColor);
    }
    public void setLeafColor(String leafColor) {
        visualEntity.setLeafColor(leafColor);
    }
    public void setSize(double size) {
        visualEntity.setSize(size);
    }

    public PlantVisualEntity getVisualEntity() {
        return visualEntity;
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

    public String toHtml() {
        return  "<tr><th>" + getId() + "</th>" +
                "<th>" + getName() + "</th>" +
                "<th>" + getSoil() + "</th>" +
                "<th>" + getOrigin() + "</th>" +
                "<th>" + getStalkColor() + "</th>" +
                "<th>" + getLeafColor() + "</th>" +
                "<th>" + getSize() + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + getMultiplying() + "</th></tr>";
    }

}
