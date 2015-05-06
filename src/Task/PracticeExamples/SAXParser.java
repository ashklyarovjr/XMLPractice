package Task.PracticeExamples;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
public class SAXParser {
    public static void main(String[] args)
    {
        try
        {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new DefaultHandler()
            {
                boolean bAuthor = false;
                boolean bLanguage = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                    if(qName.equalsIgnoreCase("AUTHOR")){
                        bAuthor = true;
                    }
                    if(qName.equalsIgnoreCase("LANGUAGE")){
                        bLanguage = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException{
                    System.out.println("End element: " + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException{
                    if(bAuthor){
                        System.out.println("Author: " + new String(ch, start, length));
                        bAuthor = false;
                    }
                    if(bLanguage){
                        System.out.println("Language: " + new String(ch, start, length));
                        bLanguage = false;
                    }
                }
            };

            saxParser.parse("iblog.xml", defaultHandler);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }
}
