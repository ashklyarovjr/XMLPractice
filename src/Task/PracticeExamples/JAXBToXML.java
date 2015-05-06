package Task.PracticeExamples; /**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBToXML {
    public static void main(String[] args)
    {
        //Переменная, ранее описанного класса(Customer):
        ClassFirstXML customer = new ClassFirstXML();
        customer.setId(100);
        customer.setName("Pavel");
        customer.setAge(99);
        try
        {
            File file = new File("jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ClassFirstXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //форматированный вывод
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }
}
