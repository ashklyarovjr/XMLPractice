package Task.Parsers;



import Task.Medicine_Structure.Medicines;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class JAXBParser {
    public static void main(String[] args) throws JAXBException {
        File file = new File( "myxml.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance(Medicines.class);


        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Medicines medicines = (Medicines)jaxbUnmarshaller.unmarshal( file );
        System.out.println( medicines.toString() );

    }

}
