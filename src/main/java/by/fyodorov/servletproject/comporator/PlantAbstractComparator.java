package by.fyodorov.servletproject.comporator;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import java.util.Comparator;

/**
 * class comparator for sorting list of XML elements after parsing by ID
 */
public class PlantAbstractComparator implements Comparator<AbstractPlantEntity> {

    /**
     * comparing 2 PlantEntities by ID
     * @param o1 - first PlantEntity
     * @param o2 - second PlantEntity
     * @return - result of comparing 2 ID
     */
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
