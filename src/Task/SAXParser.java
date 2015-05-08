package Task;


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParser {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler handler = new Handler();
            saxParser.parse("myxml.xml", handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
