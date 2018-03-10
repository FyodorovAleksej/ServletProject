package by.fyodorov.servletproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * class of growingTips
 */
@XmlType(propOrder = {"temperature", "lighting", "watering"}, name = "growingTips")
public class PlantTipEntity {
    @XmlElement
    private double temperature;
    @XmlElement
    private boolean lighting;
    @XmlElement
    private double watering;

    public PlantTipEntity() {
    }

    /**
     * getting temperature
     * @return temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * getting lighting
     * @return lighting
     */
    public boolean isLighting() {
        return lighting;
    }

    /**
     * getting watering
     * @return watering
     */
    public double getWatering() {
        return watering;
    }


    /**
     * setting temperature
     * @param temperature - temperature for current flower
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * setting lighting
     * @param lighting - lighting for current flower
     */
    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    /**
     * setting watering
     * @param watering - count of water for current flower
     */
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
