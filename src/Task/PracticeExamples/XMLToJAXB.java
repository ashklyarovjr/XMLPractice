package Task.PracticeExamples;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
public class XMLToJAXB {
    public static void main(String[] args)
    {
        try
        {
            File file = new File("jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ClassFirstXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ClassFirstXML customer = (ClassFirstXML)jaxbUnmarshaller.unmarshal(file);

            System.out.println("Customer: " + customer.getName() +
                    "(id='" + customer.getId() +
                    "',age='" + customer.getAge() +
                    "')");
        }
        catch (JAXBException jaxbe)
        {
            System.out.println(jaxbe.getLocalizedMessage());
            jaxbe.printStackTrace();
        }
    }
}
