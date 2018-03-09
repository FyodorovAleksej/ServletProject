package by.fyodorov.servletproject.entity;

public class MicroPlantEntity extends AbstractPlantEntity {
    private PlantTipEntity tipEntity;

    public MicroPlantEntity() {
        this.tipEntity = new PlantTipEntity();
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

    public String toHtml() {
        return  "<tr><th>" + getId() + "</th>" +
                "<th>" + getName() + "</th>" +
                "<th>" + getSoil() + "</th>" +
                "<th>" + getOrigin() + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + "-" + "</th>" +
                "<th>" + getTemperature() + "</th>" +
                "<th>" + isLighting() + "</th>" +
                "<th>" + getWatering() + "</th>" +
                "<th>" + getMultiplying() + "</th></tr>";
    }
}
