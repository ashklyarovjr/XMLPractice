package Task.Parsers;


import Task.AbstractMedBuilder;
import Task.Medicine_Structure.Medicines;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser extends AbstractMedBuilder{

    private Handler handler = null;

    @Override
    public Medicines parse(String fileName) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();


            handler = new Handler();

            saxParser.parse(fileName, handler);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getXMLMedicines();
    }
}
