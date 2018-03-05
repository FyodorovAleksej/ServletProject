package by.fyodorov.servletproject.entity;

public class PlantEntity {
    private int id;
    private String name;
    private String soil;
    private String origin;
    private String stalkColor;
    private String leafColor;
    private double size;
    private double temperature;
    private boolean lighting;
    private double watering;
    private String multiplying;


    public PlantEntity(int id, String name, String soil, String origin, String stalkColor, String leafColor, double size, double temperature, boolean lighting, double watering, String multiplying) {
        this.id = id;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.stalkColor = stalkColor;
        this.leafColor = leafColor;
        this.size = size;
        this.temperature = temperature;
        this.lighting =  lighting;
        this.watering = watering;
        this.multiplying = multiplying;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSoil() {
        return soil;
    }
    public String getOrigin() {
        return origin;
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
    public double getTemperature() {
        return temperature;
    }
    public boolean isLighting() {
        return lighting;
    }
    public double getWatering() {
        return watering;
    }
    public String getMultiplying() {
        return multiplying;
    }


    @Override
    public String toString() {
        return  " id = " + Integer.toString(id) +
                "; name = " + name +
                "; soil = " + soil +
                "; origin = " + origin +
                "; stalkColor = " + stalkColor +
                "; leafColor = " + leafColor +
                "; size = " + Double.toString(size) +
                "; temperature = " + Double.toString(temperature) +
                "; lighting = " + Boolean.toString(lighting) +
                "; watering = " + Double.toString(watering) +
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
        PlantEntity entity = (PlantEntity) obj;
        return  this.id == entity.id &&
                this.name.equals(entity.name) &&
                this.soil.equals(entity.soil) &&
                this.origin.equals(entity.origin) &&
                this.stalkColor.equals(entity.stalkColor) &&
                this.leafColor.equals(entity.leafColor) &&
                this.size == entity.size &&
                this.temperature == entity.temperature &&
                this.lighting == entity.lighting &&
                this.watering == entity.watering &&
                this.multiplying.equals(entity.multiplying);
    }

    @Override
    public int hashCode() {
        return  31*id +
                name.hashCode() +
                soil.hashCode() +
                origin.hashCode() +
                stalkColor.hashCode() +
                leafColor.hashCode() +
                Double.valueOf(size).hashCode() +
                Double.valueOf(temperature).hashCode() +
                Boolean.valueOf(lighting).hashCode() +
                Double.valueOf(watering).hashCode() +
                multiplying.hashCode();
    }
}
