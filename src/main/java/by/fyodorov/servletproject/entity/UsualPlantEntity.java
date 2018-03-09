package by.fyodorov.servletproject.entity;

public class UsualPlantEntity extends AbstractPlantEntity {
    private PlantVisualEntity visualEntity;
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

    public PlantVisualEntity getVisualEntity() {
        return visualEntity;
    }
    public PlantTipEntity getTipEntity() {
        return tipEntity;
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
        return  "<tr><th>" + getId() + "</th>" +
                "<th>" + getName() + "</th>" +
                "<th>" + getSoil() + "</th>" +
                "<th>" + getOrigin() + "</th>" +
                "<th>" + getStalkColor() + "</th>" +
                "<th>" + getLeafColor() + "</th>" +
                "<th>" + getSize() + "</th>" +
                "<th>" + getTemperature() + "</th>" +
                "<th>" + isLighting() + "</th>" +
                "<th>" + getWatering() + "</th>" +
                "<th>" + getMultiplying() + "</th></tr>";
    }
}
