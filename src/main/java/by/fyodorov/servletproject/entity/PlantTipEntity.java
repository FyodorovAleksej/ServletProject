package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"temperature", "lighting", "watering"}, name = "growingTips")
public class PlantTipEntity {
    @XmlElement
    private double temperature;
    @XmlElement
    private boolean lighting;
    @XmlElement
    private double watering;

    public PlantTipEntity() {
        this(0, false, 0);
    }

    public PlantTipEntity(double temperature, boolean lighting, double watering) {
        this.temperature = temperature;
        this.lighting = lighting;
        this.watering = watering;
    }

    public double getTemperature() {
        return temperature;
    }
    public boolean isLighting() {
        return lighting;
    }
    public double getWatering() {
        return watering;
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }
    public void setWatering(double watering) {
        this.watering = watering;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PlantTipEntity entity = (PlantTipEntity) obj;
        return  this.temperature == entity.temperature &&
                this.lighting == entity.lighting &&
                this.watering == entity.watering;
    }

    @Override
    public int hashCode() {
        return  Double.hashCode(temperature) +
                Boolean.hashCode(lighting) +
                Double.hashCode(watering);
    }

    @Override
    public String toString() {
        return "temperature = " + temperature +
                "; lighting = " + lighting +
                "; watering = " + watering;
    }
}
