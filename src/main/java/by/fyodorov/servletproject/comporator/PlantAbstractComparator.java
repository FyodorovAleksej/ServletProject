package by.fyodorov.servletproject.comporator;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import java.util.Comparator;

public class PlantAbstractComparator implements Comparator<AbstractPlantEntity> {
    @Override
    public int compare(AbstractPlantEntity o1, AbstractPlantEntity o2) {
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return Integer.compare(o1.getId(), o2.getId());
    }
}
