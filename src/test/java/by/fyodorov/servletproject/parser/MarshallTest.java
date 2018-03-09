package by.fyodorov.servletproject.parser;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallTest {

    @Test
    public void toXmlTest() {
        try {
            JAXBContext context = JAXBContext.newInstance(AbstractPlantEntity.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //marshaller.marshal(new AbstractPlantEntity(0, "chamomile","ground","Eurasia", "green", "white", 20, 14, true,20, "seeds"), System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
